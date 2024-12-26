package edu.diplom.agronomistadviser.domain;

import java.time.LocalDateTime;

public record DiseasePrediction(
        LocalDateTime dateTime,
        int regionId,
        EnvCondition envCondition,
        DiseaseType diseaseType,
        Integer infectionRisk,
        Integer southCLBInfectionRisk,
        Integer northCLBInfectionRisk
) {
    public record EnvCondition(
            double airTemperature,
            Integer solarRadiation,
            Integer relHumidity,
            Integer precipitation,
            Integer leafWetnessTime
    ) {
    }
}
