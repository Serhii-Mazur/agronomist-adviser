package edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionJpaRepository extends JpaRepository<RegionEntity, Integer> {
}
