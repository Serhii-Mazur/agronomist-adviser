package edu.diplom.agronomistadviser.application.service.generator.prompt;

import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import edu.diplom.agronomistadviser.domain.PlantType;
import edu.diplom.agronomistadviser.domain.DiseaseType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PromptGenerator {

    public static String getBeginPrompt(PlantType plantType, DiseaseType diseaseType) {

        return String.format(
                "Can you help with advice on preventing the development of the %s on the %s field?",
                diseaseType.description,
                plantType.description
        );
    }

    public static String getConditionsPrompt(List<DiseasePrediction> diseasePredictions) {
        if (diseasePredictions == null || diseasePredictions.isEmpty()) {
            throw new IllegalArgumentException("Error! Entrance can't be null or empty");
        } else {
            DiseaseType diseaseType = diseasePredictions.stream().findFirst().get().diseaseType();
            switch (diseaseType) {
                case FHB -> {
                    return String.format(
                            "Last %d hours observed average values of " +
                                    "air temperature - %f degrees of Celsius, " +
                                    "relative humidity - %d percents, " +
                                    "leaf wetness - %d minutes per 1 hour, " +
                                    "precipitations - %d " +
                                    "Calculated infection risk of %s - %d percents.",
                            getLastHoursNumber(diseasePredictions),
                            getAvgAirTemperature(diseasePredictions),
                            getAvgRelHumidity(diseasePredictions),
                            getAvgLeafWetnessTime(diseasePredictions),
                            getAvgPrecipitation(diseasePredictions),
                            diseaseType.description,
                            getMaxInfectionRisk(diseasePredictions)
                    );
                }
                case GMD -> {
                    return String.format(
                            "Last %d hours observed average values of " +
                                    "air temperature - %f degrees of Celsius, " +
                                    "relative humidity - %d percents, " +
                                    "leaf wetness - %d minutes per 1 hour, " +
                                    "Calculated infection risk of %s - %d percents.",
                            getLastHoursNumber(diseasePredictions),
                            getAvgAirTemperature(diseasePredictions),
                            getAvgRelHumidity(diseasePredictions),
                            getAvgLeafWetnessTime(diseasePredictions),
                            diseaseType.description,
                            getMaxInfectionRisk(diseasePredictions)
                    );
                }
                case PMB -> {
                    return String.format(
                            "Last %d hours observed average values of " +
                                    "air temperature - %f degrees of Celsius, " +
                                    "solar radiation - %d Watt on square meter, " +
                                    "leaf wetness - %d minutes per 1 hour, " +
                                    "Calculated infection risk of %s - %d percents.",
                            getLastHoursNumber(diseasePredictions),
                            getAvgAirTemperature(diseasePredictions),
                            getAvgSolarRadiation(diseasePredictions),
                            getAvgLeafWetnessTime(diseasePredictions),
                            diseaseType.description,
                            getMaxInfectionRisk(diseasePredictions)
                    );
                }
                case LBH -> {
                    return String.format(
                            "Last %d hours observed average values of " +
                                    "air temperature - %f degrees of Celsius, " +
                                    "relative humidity - %d percents, " +
                                    "leaf wetness - %d minutes per 1 hour, " +
                                    "precipitations - %d " +
                                    "Calculated risks of %s: south CLB infection risk - %d percents, " +
                                    "north CLB infection risk - %d percents",
                            getLastHoursNumber(diseasePredictions),
                            getAvgAirTemperature(diseasePredictions),
                            getAvgRelHumidity(diseasePredictions),
                            getAvgLeafWetnessTime(diseasePredictions),
                            getAvgPrecipitation(diseasePredictions),
                            diseaseType.description,
                            getMaxSouthClbInfectionRisk(diseasePredictions),
                            getMaxNorthClbInfectionRisk(diseasePredictions)
                    );
                }
                default -> {
                    return "Unfortunately, can't give you additional data about environment conditions.";
                }

            }
        }

    }

    public static String getAdviceRequestPrompt(PlantType plantType, DiseaseType diseaseType) {

        return "";
    }

    private static int getLastHoursNumber(List<DiseasePrediction> diseasePredictions) {

        return diseasePredictions.size();
    }

    private static double getAvgAirTemperature(List<DiseasePrediction> diseasePredictions) {

        return diseasePredictions.stream()
                .map(DiseasePrediction::envCondition)
                .filter(Objects::nonNull)
                .mapToDouble(DiseasePrediction.EnvCondition::airTemperature)
                .average()
                .getAsDouble();
    }

    private static int getAvgRelHumidity(List<DiseasePrediction> diseasePredictions) {

        return (int) diseasePredictions.stream()
                .map(DiseasePrediction::envCondition)
                .filter(Objects::nonNull)
                .mapToDouble(DiseasePrediction.EnvCondition::relHumidity)
                .average()
                .getAsDouble();
    }

    private static int getAvgSolarRadiation(List<DiseasePrediction> diseasePredictions) {

        return (int) diseasePredictions.stream()
                .map(DiseasePrediction::envCondition)
                .filter(Objects::nonNull)
                .mapToDouble(DiseasePrediction.EnvCondition::solarRadiation)
                .average()
                .getAsDouble();
    }

    private static int getAvgLeafWetnessTime(List<DiseasePrediction> diseasePredictions) {

        return (int) diseasePredictions.stream()
                .map(DiseasePrediction::envCondition)
                .filter(Objects::nonNull)
                .mapToDouble(DiseasePrediction.EnvCondition::leafWetnessTime)
                .average()
                .getAsDouble();
    }

    private static int getAvgPrecipitation(List<DiseasePrediction> diseasePredictions) {

        return (int) diseasePredictions.stream()
                .map(DiseasePrediction::envCondition)
                .filter(Objects::nonNull)
                .mapToDouble(DiseasePrediction.EnvCondition::precipitation)
                .average()
                .getAsDouble();
    }

    private static int getMaxInfectionRisk(List<DiseasePrediction> diseasePredictions) {

        return diseasePredictions.stream()
                .filter(p -> p.infectionRisk() != null)
                .mapToInt(DiseasePrediction::infectionRisk)
                .max()
                .getAsInt();
    }

    private static int getMaxSouthClbInfectionRisk(List<DiseasePrediction> diseasePredictions) {

        return diseasePredictions.stream()
                .filter(p -> p.infectionRisk() != null)
                .mapToInt(DiseasePrediction::southCLBInfectionRisk)
                .max()
                .getAsInt();
    }

    private static int getMaxNorthClbInfectionRisk(List<DiseasePrediction> diseasePredictions) {

        return diseasePredictions.stream()
                .filter(p -> p.infectionRisk() != null)
                .mapToInt(DiseasePrediction::northCLBInfectionRisk)
                .max()
                .getAsInt();
    }
}
