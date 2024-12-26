package edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.DiseaseGmdSunflowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface GmdSunflowerJpaRepository extends JpaRepository<DiseaseGmdSunflowerEntity, Long> {

    List<DiseaseGmdSunflowerEntity> findAllByRegionIdAndDateTimeBetween(int regionId, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);
}
