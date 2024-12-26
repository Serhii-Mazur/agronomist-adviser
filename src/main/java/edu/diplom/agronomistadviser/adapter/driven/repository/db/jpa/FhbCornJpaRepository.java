package edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseaseFhbCornEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FhbCornJpaRepository extends JpaRepository<DiseaseFhbCornEntity, Long> {
    List<DiseaseFhbCornEntity> findAllByRegionIdAndDateTimeBetween(int regionId, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);
}
