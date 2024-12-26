package edu.diplom.agronomistadviser.adapter.driven.repository.api;

import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.AiMlChatCompletionlApi;
import edu.diplom.agronomistadviser.adapter.driven.repository.mapper.AiMlChatCompletionMapper;
import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.AiMlChatParams;
import edu.diplom.agronomistadviser.application.port.repository.api.ChatCompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatCompletionRepositoryImpl implements ChatCompletionRepository {

    @Autowired
    private AiMlChatCompletionlApi aiMlChatCompletionlApi;

    @Override
    public String completeChat(String message, AiMlChatParams aiMlChatParams) {

        return aiMlChatCompletionlApi.completeChat(
                        AiMlChatCompletionMapper.toRequest(
                                message,
                                aiMlChatParams
                        )
                ).choices()
                .get(0)
                .message()
                .content();
    }
}
