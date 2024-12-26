package edu.diplom.agronomistadviser.application.usecase;

import edu.diplom.agronomistadviser.adapter.driven.notification.email.EmailDetails;
import edu.diplom.agronomistadviser.application.port.notification.UserNotifier;
import edu.diplom.agronomistadviser.application.port.repository.db.RegionRepository;
import edu.diplom.agronomistadviser.application.port.usecase.CheckLastPredictionsUseCase;
import edu.diplom.agronomistadviser.application.port.usecase.GetAiAdviceUseCase;
import edu.diplom.agronomistadviser.application.port.usecase.GetLastPredictionsUseCase;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import edu.diplom.agronomistadviser.domain.PlantType;
import edu.diplom.agronomistadviser.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CheckLastPredictionsUseCaseImpl implements CheckLastPredictionsUseCase {
    private final RegionRepository regionRepository;
    private final GetLastPredictionsUseCase getLastPredictionsUseCase;
    private final GetAiAdviceUseCase getAiAdviceUseCase;
    private final UserNotifier userNotifier;

    private final int lasHoursNumber = 6;
    private final int infectionRiskThreshold = 20;
    private final String recipient = "mazur.se.m@nmu.one";

    @Autowired
    public CheckLastPredictionsUseCaseImpl(RegionRepository regionRepository, GetLastPredictionsUseCase getLastPredictionsUseCase, GetAiAdviceUseCase getAiAdviceUseCase, UserNotifier userNotifier) {
        this.regionRepository = regionRepository;
        this.getLastPredictionsUseCase = getLastPredictionsUseCase;
        this.getAiAdviceUseCase = getAiAdviceUseCase;
        this.userNotifier = userNotifier;
    }

    @Override
    public void run(PlantType plantType, DiseaseType diseaseType) {
        Map<Integer, List<DiseasePrediction>> problems = new HashMap<>();

        List<Region> regions = regionRepository.findAll();

        regions.forEach(region -> {
                    List<DiseasePrediction> predictions = getLastPredictionsUseCase.run(
                            region.id(),
                            plantType,
                            diseaseType,
                            lasHoursNumber
                    );
                    if (predictions != null && !predictions.isEmpty()) {
                        int maxInfectionRisk = predictions.stream()
                                .filter(p -> p.infectionRisk() != null)
                                .mapToInt(DiseasePrediction::infectionRisk)
                                .max()
                                .getAsInt();
                        if (maxInfectionRisk > infectionRiskThreshold) {
                            problems.put(region.id(), predictions);
                        }
                        String aiResponse = String.join(
                                "\n",
                                getAiAdviceUseCase.run(plantType, problems.get(region.id())).values()
                        );

                        String message = String.format(
                                """
                                        Dear agronomist. High risk of %s detected for your corn fields.
                                        Last %d hours next conditions observed in region %s:
                                        %s
                                        We prepared some recommendations for you to prevent disease outbreak, using AI.
                                        AI generated recommendations below.
                                        %s""",
                                DiseaseType.FHB.description,
                                lasHoursNumber,
                                region.description(),
                                predictions,
                                aiResponse
                        );

                        userNotifier.sendMail(new EmailDetails(
                                        recipient,
                                        "high infection risk alert!",
                                        message
                                )
                        );
                    }
                }
        );
    }
}
