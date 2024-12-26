package edu.diplom.agronomistadviser.adapter.driven.repository.db;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa.PmbWheatJpaRepository;
import edu.diplom.agronomistadviser.adapter.driven.repository.mapper.DiseasePredictionMapper;
import edu.diplom.agronomistadviser.application.port.repository.db.PmbWheatRepository;
import edu.diplom.agronomistadviser.domain.DiseasePrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PmbWheatRepositoryImpl implements PmbWheatRepository {
    private final PmbWheatJpaRepository jpaRepository;

    @Autowired
    public PmbWheatRepositoryImpl(PmbWheatJpaRepository jpaRepository) {
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
                        .map(DiseasePredictionMapper::toPmbWheatEntity)
                        .toList())
                .stream()
                .map(DiseasePredictionMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteAllByIds(List<Long> ids) {
        jpaRepository.deleteAllByIdInBatch(ids);
    }
}
