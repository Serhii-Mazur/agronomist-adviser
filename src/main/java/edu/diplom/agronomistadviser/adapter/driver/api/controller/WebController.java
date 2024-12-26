package edu.diplom.agronomistadviser.adapter.driver.api.controller;

import edu.diplom.agronomistadviser.adapter.driver.api.model.AiAdviceResponse;
import edu.diplom.agronomistadviser.adapter.driver.api.model.DiseasePredictionDto;
import edu.diplom.agronomistadviser.adapter.driver.api.model.DiseasePredictionRequest;
import edu.diplom.agronomistadviser.adapter.driver.api.model.DiseasePredictionResponse;
import edu.diplom.agronomistadviser.application.port.usecase.GetLastPredictionsUseCase;
import edu.diplom.agronomistadviser.application.port.usecase.SaveDiseasePredictionsUseCase;
import edu.diplom.agronomistadviser.application.usecase.GetAiAdviceUseCaseImpl;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.PlantType;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class WebController {
    private final GetLastPredictionsUseCase getLastPredictionsUseCase;
    private final SaveDiseasePredictionsUseCase saveDiseasePredictionsUseCase;
    private final GetAiAdviceUseCaseImpl getAiAdviceUseCase;

    @Autowired
    public WebController(
            GetLastPredictionsUseCase getLastPredictionsUseCase,
            SaveDiseasePredictionsUseCase saveDiseasePredictionsUseCase,
            GetAiAdviceUseCaseImpl getAiAdviceUseCase
    ) {
        this.getLastPredictionsUseCase = getLastPredictionsUseCase;
        this.saveDiseasePredictionsUseCase = saveDiseasePredictionsUseCase;
        this.getAiAdviceUseCase = getAiAdviceUseCase;
    }

    @GetMapping("/predictions/last")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public DiseasePredictionResponse getLastPredictionsByRegionId(
            @RequestParam("regionId") int regionId,
            @RequestParam("plantType") PlantType plantType,
            @RequestParam("diseaseType") DiseaseType diseaseType,
            @RequestParam("hoursNumber") int hoursNumber
    ) {

        return DiseasePredictionResponse.toResponse(
                getLastPredictionsUseCase.run(regionId, plantType, diseaseType, hoursNumber)
        );
    }

    @PostMapping("/predictions/new")
    @ResponseStatus(HttpStatus.OK)
    public void saveDiseasePredictions(
            @RequestBody DiseasePredictionRequest request
    ) {
        saveDiseasePredictionsUseCase.run(
                request.plantDiseasePrediction().plantType(),
                request.plantDiseasePrediction().diseasePredictions().stream()
                        .map(req -> new DiseasePrediction(
                                        req.dateTime(),
                                        req.regionId(),
                                        DiseasePredictionDto.EnvironmentDto.toDomain(req.environmentDto()),
                                        req.diseaseType(),
                                        req.infectionRisk(),
                                        req.southClbInfectionRisk(),
                                        req.northClbInfectionRisk()
                                )
                        ).toList()
        );
    }

    @GetMapping("/advices/prevention")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AiAdviceResponse getDiseasePreventionAiAdvice(
            @RequestParam("regionId") int regionId,
            @RequestParam("plantType") PlantType plantType,
            @RequestParam("diseaseType") DiseaseType diseaseType
    ) {
        List<DiseasePrediction> diseasePredictions = getLastPredictionsUseCase.run(regionId, plantType, diseaseType, 6);
        Map<String, String> aiChatResults = getAiAdviceUseCase.run(plantType, diseasePredictions);

        return AiAdviceResponse.toResponse(aiChatResults);
    }
}
