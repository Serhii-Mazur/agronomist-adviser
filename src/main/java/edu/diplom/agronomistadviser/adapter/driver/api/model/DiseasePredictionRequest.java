package edu.diplom.agronomistadviser.adapter.driver.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.PlantType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DiseasePredictionRequest(

        @NotNull
        @JsonProperty("plantDiseasePrediction")
        PlantDiseasePrediction plantDiseasePrediction
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PlantDiseasePrediction(
            @NotNull
            @JsonProperty("plantType")
            PlantType plantType,

            @NotNull
            @JsonProperty("diseasePredictions")
            List<DiseasePredictionDto> diseasePredictions
    ){

    }
}
