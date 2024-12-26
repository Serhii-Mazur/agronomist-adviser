package edu.diplom.agronomistadviser.application.usecase;

import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.AiMlChatParams;
import edu.diplom.agronomistadviser.application.port.repository.api.ChatCompletionRepository;
import edu.diplom.agronomistadviser.application.port.usecase.GetAiAdviceUseCase;
import edu.diplom.agronomistadviser.application.service.generator.prompt.PromptGenerator;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import edu.diplom.agronomistadviser.domain.PlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GetAiAdviceUseCaseImpl implements GetAiAdviceUseCase {

    private final ChatCompletionRepository chatCompletionRepository;

    @Value("${aiml.model}")
    private String aiModel;

    @Value("${aiml.consumer.role}")
    private String aiConsumerRole;

    @Value("${aiml.max-tokens}")
    private int aiMaxTokens;

    @Value("${aiml.temperature}")
    private float aiTemperature;

    @Autowired
    public GetAiAdviceUseCaseImpl(ChatCompletionRepository chatCompletionRepository) {
        this.chatCompletionRepository = chatCompletionRepository;
    }

    @Override
    public Map<String, String> run(PlantType plantType, List<DiseasePrediction> diseasePredictions) {
        DiseaseType diseaseType = null;
        Optional<DiseaseType> optDiseaseType = diseasePredictions.stream()
                .findFirst()
                .map(DiseasePrediction::diseaseType);
        if (optDiseaseType.isPresent()) {
            diseaseType = optDiseaseType.get();
        } else {
            throw new IllegalArgumentException("Error: Disease type can't be null");
        }
        List<String> messages = new ArrayList<>();
        messages.add(0, PromptGenerator.getBeginPrompt(plantType, diseaseType));
        messages.add(1, PromptGenerator.getConditionsPrompt(diseasePredictions));
        messages.add(2, PromptGenerator.getAdviceRequestPrompt(plantType, diseaseType));

        Map<String, String> aiChatResults = new HashMap<>();
        int i = 0;
        for (String message : messages) {
            aiChatResults.put(messages.get(i), chatCompletionRepository.completeChat(
                            message,
                            new AiMlChatParams(
                                    aiConsumerRole,
                                    aiModel,
                                    aiMaxTokens,
                                    aiTemperature,
                                    false
                            )
                    )
            );
            i++;
        }

        return aiChatResults;
    }
}
