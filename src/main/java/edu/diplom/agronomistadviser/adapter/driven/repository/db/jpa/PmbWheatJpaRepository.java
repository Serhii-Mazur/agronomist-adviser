package edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseasePmbWheatEntity;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface PmbWheatJpaRepository extends JpaRepository<DiseasePmbWheatEntity, Long> {

    List<DiseasePmbWheatEntity> findAllByRegionIdAndDateTimeBetween(int regionId, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);
}
