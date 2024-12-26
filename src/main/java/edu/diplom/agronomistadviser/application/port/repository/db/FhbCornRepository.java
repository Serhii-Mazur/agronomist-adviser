package edu.diplom.agronomistadviser.application.port.repository.db;

import edu.diplom.agronomistadviser.domain.DiseasePrediction;

import java.time.LocalDateTime;
import java.util.List;

public interface FhbCornRepository {
    List<DiseasePrediction> findAllByRegionIdAndDateTimeBetween(
            int regionId,
            LocalDateTime dateTimeStart,
            LocalDateTime dateTimeEnd
    );

    List<DiseasePrediction> saveAll(List<DiseasePrediction> domains);

    void deleteAllByIds(List<Long> ids);
}
