package edu.diplom.agronomistadviser.adapter.driven.repository.db;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa.GmdSunflowerJpaRepository;
import edu.diplom.agronomistadviser.adapter.driven.repository.mapper.DiseasePredictionMapper;
import edu.diplom.agronomistadviser.application.port.repository.db.GmdSunflowerRepository;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class GmdSunflowerRepositoryImpl implements GmdSunflowerRepository {
    private final GmdSunflowerJpaRepository jpaRepository;

    @Autowired
    public GmdSunflowerRepositoryImpl(GmdSunflowerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<DiseasePrediction> findAllByRegionIdAndDateTimeBetween(int regionId, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        return jpaRepository.findAllByRegionIdAndDateTimeBetween(
                        regionId,
                        dateTimeStart,
                        dateTimeEnd)
                .stream()
                .map(DiseasePredictionMapper::toDomain)
                .toList();
    }

    @Override
    public List<DiseasePrediction> saveAll(List<DiseasePrediction> domains) {

        return jpaRepository.saveAllAndFlush(domains.stream()
                        .map(DiseasePredictionMapper::toGmdSunflowerEntity)
                        .toList()).stream()
                .map(DiseasePredictionMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteAllByIds(List<Long> ids) {
        jpaRepository.deleteAllByIdInBatch(ids);
    }
}
