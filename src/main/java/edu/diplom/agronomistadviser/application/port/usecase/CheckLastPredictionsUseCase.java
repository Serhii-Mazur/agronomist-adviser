package edu.diplom.agronomistadviser.application.port.usecase;

import edu.diplom.agronomistadviser.domain.DiseaseType;
import edu.diplom.agronomistadviser.domain.PlantType;

public interface CheckLastPredictionsUseCase {
    void run(PlantType plantType, DiseaseType diseaseType);
}
