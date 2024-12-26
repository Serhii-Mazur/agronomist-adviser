package edu.diplom.agronomistadviser.adapter.driver.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DiseasePredictionDto(

        @NotNull
        @JsonProperty("dateTime")
        LocalDateTime dateTime,

        @JsonProperty("regionId")
        int regionId,

        @NotNull
        @JsonProperty("environment")
        EnvironmentDto environmentDto,

        @NotNull
        @JsonProperty("diseaseType")
        DiseaseType diseaseType,

        @JsonProperty("infectionRisk")
        Integer infectionRisk,

        @JsonProperty("southClbInfectionRisk")
        Integer southClbInfectionRisk,

        @JsonProperty("northClbInfectionRisk")
        Integer northClbInfectionRisk
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record EnvironmentDto(

            @NotNull
            @JsonProperty("airTemperature")
            double airTemperature,

            @JsonProperty("solarRadiation")
            Integer solarRadiation,

            @JsonProperty("relHumidity")
            Integer relHumidity,

            @JsonProperty("precipitation")
            Integer precipitation,

            @JsonProperty("leafWetnessTime")
            Integer leafWetnessTime
    ) {
        public static DiseasePrediction.EnvCondition toDomain(EnvironmentDto dto) {

            return new DiseasePrediction.EnvCondition(
                    dto.airTemperature(),
                    dto.solarRadiation(),
                    dto.relHumidity(),
                    dto.precipitation(),
                    dto.leafWetnessTime()
            );
        }
    }
}
