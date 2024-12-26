package edu.diplom.agronomistadviser.adapter.driver.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DiseasePredictionResponse(

        @NotNull
        @JsonProperty("diseasePredictions")
        List<DiseasePredictionDto> diseasePredictions
) {
        public static DiseasePredictionResponse toResponse(List<DiseasePrediction> domains) {
                return new DiseasePredictionResponse(
                        domains.stream()
                                .map(DiseasePredictionResponse::toDto)
                                .toList()
                );

        }

        public static DiseasePredictionDto toDto(DiseasePrediction domain) {
                DiseasePredictionDto.EnvironmentDto environmentDto = new DiseasePredictionDto.EnvironmentDto(
                        domain.envCondition().airTemperature(),
                        domain.envCondition().solarRadiation(),
                        domain.envCondition().relHumidity(),
                        domain.envCondition().precipitation(),
                        domain.envCondition().leafWetnessTime()
                );

                return new DiseasePredictionDto(
                        domain.dateTime(),
                        domain.regionId(),
                        environmentDto,
                        domain.diseaseType(),
                        domain.infectionRisk(),
                        domain.southCLBInfectionRisk(),
                        domain.northCLBInfectionRisk()
                );
        }
}
