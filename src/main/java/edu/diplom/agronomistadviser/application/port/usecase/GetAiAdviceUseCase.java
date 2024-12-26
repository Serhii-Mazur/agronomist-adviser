package edu.diplom.agronomistadviser.application.port.usecase;

import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.PlantType;

import java.util.List;
import java.util.Map;

public interface GetAiAdviceUseCase {
    Map<String, String> run(PlantType plantType, List<DiseasePrediction> diseasePredictions);
}
