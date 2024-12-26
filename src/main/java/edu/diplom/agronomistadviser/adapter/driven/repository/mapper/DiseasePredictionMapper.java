package edu.diplom.agronomistadviser.adapter.driven.repository.mapper;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseaseFhbCornEntity;
import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseaseGmdSunflowerEntity;
import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseaseLbhCornEntity;
import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseasePmbWheatEntity;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import edu.diplom.agronomistadviser.domain.DiseasePrediction.EnvCondition;

public class DiseasePredictionMapper {

    public static DiseasePrediction toDomain(DiseaseFhbCornEntity entity) {
        EnvCondition envCondition = new EnvCondition(
                entity.getAirTemperature(),
                null,
                entity.getRelHumidity(),
                entity.getPrecipitation(),
                entity.getLeafWetnessTime()
        );

        return new DiseasePrediction(
                entity.getDateTime(),
                entity.getRegionId(),
                envCondition,
                DiseaseType.FHB,
                entity.getInfectionRisk(),
                null,
                null
        );
    }

    public static DiseaseFhbCornEntity toFhbCornEntity(DiseasePrediction domain) {

        return new DiseaseFhbCornEntity(
                domain.dateTime(),
                domain.regionId(),
                domain.envCondition().airTemperature(),
                domain.envCondition().relHumidity(),
                domain.envCondition().precipitation(),
                domain.envCondition().leafWetnessTime(),
                domain.infectionRisk()
        );
    }

    public static DiseasePrediction toDomain(DiseaseGmdSunflowerEntity entity) {
        EnvCondition envCondition = new EnvCondition(
                entity.getAirTemperature(),
                null,
                entity.getRelHumidity(),
                null,
                entity.getLeafWetnessTime()
        );

        return new DiseasePrediction(
                entity.getDateTime(),
                entity.getRegionId(),
                envCondition,
                DiseaseType.GMD,
                entity.getInfectionRisk(),
                null,
                null
        );
    }

    public static DiseaseGmdSunflowerEntity toGmdSunflowerEntity(DiseasePrediction domain) {

        return new DiseaseGmdSunflowerEntity(
                domain.dateTime(),
                domain.regionId(),
                domain.envCondition().airTemperature(),
                domain.envCondition().relHumidity(),
                domain.envCondition().leafWetnessTime(),
                domain.infectionRisk()
        );
    }

    public static DiseasePrediction toDomain(DiseasePmbWheatEntity entity) {
        EnvCondition envCondition = new EnvCondition(
                entity.getAirTemperature(),
                entity.getSolarRadiation(),
                null,
                null,
                entity.getLeafWetnessTime()
        );

        return new DiseasePrediction(
                entity.getDateTime(),
                entity.getRegionId(),
                envCondition,
                DiseaseType.PMB,
                entity.getInfectionRisk(),
                null,
                null
        );
    }

    public static DiseasePmbWheatEntity toPmbWheatEntity(DiseasePrediction domain) {

        return new DiseasePmbWheatEntity(
                domain.dateTime(),
                domain.regionId(),
                domain.envCondition().airTemperature(),
                domain.envCondition().solarRadiation(),
                domain.envCondition().leafWetnessTime(),
                domain.infectionRisk()
        );
    }

    public static DiseasePrediction toDomain(DiseaseLbhCornEntity entity) {
        EnvCondition envCondition = new EnvCondition(
                entity.getAirTemperature(),
                null,
                entity.getRelHumidity(),
                entity.getPrecipitation(),
                entity.getLeafWetnessTime()
        );

        return new DiseasePrediction(
                entity.getDateTime(),
                entity.getRegionId(),
                envCondition,
                DiseaseType.LBH,
                null,
                entity.getSouthClbInfectionRisk(),
                entity.getNorthClbInfectionRisk()
        );
    }

    public static DiseaseLbhCornEntity toLbhCornEntity(DiseasePrediction domain) {

        return new DiseaseLbhCornEntity(
                domain.dateTime(),
                domain.regionId(),
                domain.envCondition().airTemperature(),
                domain.envCondition().relHumidity(),
                domain.envCondition().precipitation(),
                domain.envCondition().leafWetnessTime(),
                domain.southCLBInfectionRisk(),
                domain.northCLBInfectionRisk()
        );
    }
}
