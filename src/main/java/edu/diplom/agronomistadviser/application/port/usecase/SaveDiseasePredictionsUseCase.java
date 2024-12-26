package edu.diplom.agronomistadviser.application.port.usecase;

import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.PlantType;

import java.util.List;

public interface SaveDiseasePredictionsUseCase {

    void run(PlantType plantType, List<DiseasePrediction> diseasePredictions);
}
