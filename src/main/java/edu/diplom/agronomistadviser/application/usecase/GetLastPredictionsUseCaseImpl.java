package edu.diplom.agronomistadviser.application.usecase;

import edu.diplom.agronomistadviser.application.port.repository.db.FhbCornRepository;
import edu.diplom.agronomistadviser.application.port.repository.db.GmdSunflowerRepository;
import edu.diplom.agronomistadviser.application.port.repository.db.LbhCornRepository;
import edu.diplom.agronomistadviser.application.port.repository.db.PmbWheatRepository;
import edu.diplom.agronomistadviser.application.port.usecase.GetLastPredictionsUseCase;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import edu.diplom.agronomistadviser.domain.PlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetLastPredictionsUseCaseImpl implements GetLastPredictionsUseCase {
    private final FhbCornRepository fhbCornRepository;
    private final PmbWheatRepository pmbWheatRepository;
    private final GmdSunflowerRepository gmdSunflowerRepository;
    private final LbhCornRepository lbhCornRepository;

    @Autowired
    public GetLastPredictionsUseCaseImpl(FhbCornRepository fhbCornRepository, PmbWheatRepository pmbWheatRepository, GmdSunflowerRepository gmdSunflowerRepository, LbhCornRepository lbhCornRepository) {
        this.fhbCornRepository = fhbCornRepository;
        this.pmbWheatRepository = pmbWheatRepository;
        this.gmdSunflowerRepository = gmdSunflowerRepository;
        this.lbhCornRepository = lbhCornRepository;
    }

    @Override
    public List<DiseasePrediction> run(int regionId, PlantType plantType, DiseaseType diseaseType, int hoursNumber) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        List<DiseasePrediction> predictions = new ArrayList<>();
        switch (diseaseType) {
            case FHB -> {
                switch (plantType) {
                    case CORN -> {
                        predictions = fhbCornRepository.findAllByRegionIdAndDateTimeBetween(
                                regionId,
                                now.minusHours(hoursNumber),
                                now
                        );
                    }
                    case WHEAT, SUNFLOWER -> {
                        // TODO: Not implemented yet
                    }
                }
            }
            case GMD -> {
                switch (plantType) {
                    case SUNFLOWER -> {
                        predictions = gmdSunflowerRepository.findAllByRegionIdAndDateTimeBetween(
                                regionId,
                                now.minusHours(hoursNumber),
                                now
                        );
                    }
                    case WHEAT, CORN -> {
                        // TODO: Not implemented yet
                    }
                }
            }
            case LBH -> {
                switch (plantType) {
                    case CORN -> {
                        predictions = lbhCornRepository.findAllByRegionIdAndDateTimeBetween(
                                regionId,
                                now.minusHours(hoursNumber),
                                now
                        );
                    }
                    case WHEAT, SUNFLOWER -> {
                        // TODO: Not implemented yet
                    }
                }
            }
            case PMB -> {
                switch (plantType) {
                    case WHEAT -> {
                        predictions = pmbWheatRepository.findAllByRegionIdAndDateTimeBetween(
                                regionId,
                                now.minusHours(hoursNumber),
                                now
                        );
                    }
                    case CORN, SUNFLOWER -> {
                        // TODO: Not implemented yet
                    }
                }
            }
            default -> throw new IllegalArgumentException(String.format("Unknown disease type: %s", diseaseType));
        }

        return predictions;
    }
}
