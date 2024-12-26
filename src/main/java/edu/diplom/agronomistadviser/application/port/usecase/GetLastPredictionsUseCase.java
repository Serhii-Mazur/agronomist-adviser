package edu.diplom.agronomistadviser.application.port.usecase;

import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.PlantType;
import edu.diplom.agronomistadviser.domain.DiseaseType;

import java.util.List;

public interface GetLastPredictionsUseCase {
    List<DiseasePrediction> run(int regionId, PlantType plantType, DiseaseType diseaseType, int hoursNumber);
}
