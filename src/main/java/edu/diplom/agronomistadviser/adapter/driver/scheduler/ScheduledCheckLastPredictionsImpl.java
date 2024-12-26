package edu.diplom.agronomistadviser.adapter.driver.scheduler;

import edu.diplom.agronomistadviser.application.port.notification.UserNotifier;
import edu.diplom.agronomistadviser.application.port.repository.db.RegionRepository;
import edu.diplom.agronomistadviser.application.port.scheduler.ScheduledCheckLastPredictions;
import edu.diplom.agronomistadviser.application.port.usecase.CheckLastPredictionsUseCase;
import edu.diplom.agronomistadviser.application.port.usecase.GetAiAdviceUseCase;
import edu.diplom.agronomistadviser.application.port.usecase.GetLastPredictionsUseCase;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import edu.diplom.agronomistadviser.domain.PlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledCheckLastPredictionsImpl implements ScheduledCheckLastPredictions {
    private final CheckLastPredictionsUseCase checkLastPredictionsUseCase;

    @Autowired
    public ScheduledCheckLastPredictionsImpl(CheckLastPredictionsUseCase checkLastPredictionsUseCase, GetLastPredictionsUseCase getLastPredictionsUseCase, RegionRepository regionRepository, GetAiAdviceUseCase getAiAdviceUseCase, UserNotifier userNotifier) {
        this.checkLastPredictionsUseCase = checkLastPredictionsUseCase;
    }

    @Scheduled(cron = "0 5 */6 * * *")
    @Override
    public void checkLastPredictionsForCornFHB() {
        PlantType plantType = PlantType.CORN;
        DiseaseType diseaseType = DiseaseType.FHB;
        checkLastPredictionsUseCase.run(plantType, diseaseType);
    }

    @Scheduled(cron = "0 10 */6 * * *")
    @Override
    public void checkLastPredictionsForSunflowerGMD() {
        PlantType plantType = PlantType.SUNFLOWER;
        DiseaseType diseaseType = DiseaseType.GMD;
        checkLastPredictionsUseCase.run(plantType, diseaseType);
    }

    @Scheduled(cron = "0 15 */6 * * *")
    @Override
    public void checkLastPredictionsForWheatPMB() {
        PlantType plantType = PlantType.WHEAT;
        DiseaseType diseaseType = DiseaseType.PMB;
        checkLastPredictionsUseCase.run(plantType, diseaseType);
    }

    @Scheduled(cron = "0 20 */6 * * *")
    @Override
    public void checkLastPredictionsForCornLBH() {
        PlantType plantType = PlantType.CORN;
        DiseaseType diseaseType = DiseaseType.LBH;
        checkLastPredictionsUseCase.run(plantType, diseaseType);
    }
}
