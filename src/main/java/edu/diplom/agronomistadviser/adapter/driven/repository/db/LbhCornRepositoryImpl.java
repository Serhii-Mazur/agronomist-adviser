package edu.diplom.agronomistadviser.adapter.driven.repository.db;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa.LbhCornJpaRepository;
import edu.diplom.agronomistadviser.adapter.driven.repository.mapper.DiseasePredictionMapper;
import edu.diplom.agronomistadviser.application.port.repository.db.LbhCornRepository;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class LbhCornRepositoryImpl implements LbhCornRepository {
    private final LbhCornJpaRepository jpaRepository;

    @Autowired
    public LbhCornRepositoryImpl(LbhCornJpaRepository jpaRepository) {
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

        return jpaRepository.saveAllAndFlush(
                        domains.stream()
                                .map(DiseasePredictionMapper::toLbhCornEntity)
                                .toList()
                ).stream()
                .map(DiseasePredictionMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteAllByIds(List<Long> ids) {
        jpaRepository.deleteAllByIdInBatch(ids);
    }
}
