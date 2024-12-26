package edu.diplom.agronomistadviser.application.usecase;

import edu.diplom.agronomistadviser.application.port.repository.db.FhbCornRepository;
import edu.diplom.agronomistadviser.application.port.repository.db.GmdSunflowerRepository;
import edu.diplom.agronomistadviser.application.port.repository.db.LbhCornRepository;
import edu.diplom.agronomistadviser.application.port.repository.db.PmbWheatRepository;
import edu.diplom.agronomistadviser.application.port.usecase.SaveDiseasePredictionsUseCase;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.PlantType;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveDiseasePredictionsUseCaseImpl implements SaveDiseasePredictionsUseCase {
    private final FhbCornRepository fhbCornRepository;
    private final LbhCornRepository lbhCornRepository;
    private final PmbWheatRepository pmbWheatRepository;
    private final GmdSunflowerRepository gmdSunflowerRepository;

    @Autowired
    public SaveDiseasePredictionsUseCaseImpl(FhbCornRepository fhbCornRepository,
                                             LbhCornRepository lbhCornRepository,
                                             PmbWheatRepository pmbWheatRepository,
                                             GmdSunflowerRepository gmdSunflowerRepository
    ) {
        this.fhbCornRepository = fhbCornRepository;
        this.lbhCornRepository = lbhCornRepository;
        this.pmbWheatRepository = pmbWheatRepository;
        this.gmdSunflowerRepository = gmdSunflowerRepository;
    }

    @Override
    public void run(PlantType plantType, List<DiseasePrediction> diseasePredictions) {
        DiseaseType diseaseType = diseasePredictions.stream().findFirst().get().diseaseType();
        switch (diseaseType) {
            case FHB -> {
                switch (plantType) {
                    case CORN -> fhbCornRepository.saveAll(diseasePredictions);
                    case WHEAT, SUNFLOWER -> {
                        // TODO: Not implemented yet
                    }
                }
            }
            case LBH -> {
                switch (plantType) {
                    case CORN -> lbhCornRepository.saveAll(diseasePredictions);
                    case WHEAT, SUNFLOWER -> {
                        // TODO: Not implemented yet
                    }
                }
            }
            case PMB -> pmbWheatRepository.saveAll(diseasePredictions);
            case GMD -> gmdSunflowerRepository.saveAll(diseasePredictions);
            default -> throw new IllegalArgumentException(String.format("Unknown disease type: %s", diseasePredictions));
        }
    }
}
