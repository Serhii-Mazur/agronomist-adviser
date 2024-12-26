package edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseaseLbhCornEntity;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface LbhCornJpaRepository extends JpaRepository<DiseaseLbhCornEntity, Long> {

    List<DiseaseLbhCornEntity> getByDateTimeIn(List<LocalDateTime> dateTimes);

    List<DiseaseLbhCornEntity> findAllByRegionIdAndDateTimeBetween(int regionId, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);
}
