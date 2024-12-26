package edu.diplom.agronomistadviser.adapter.driven.repository.db;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.RegionEntity;
import edu.diplom.agronomistadviser.adapter.driven.repository.db.jpa.RegionJpaRepository;
import edu.diplom.agronomistadviser.adapter.driven.repository.mapper.RegionMapper;
import edu.diplom.agronomistadviser.application.port.repository.db.RegionRepository;
import edu.diplom.agronomistadviser.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegionRepositoryImpl implements RegionRepository {
    private final RegionJpaRepository jpaRepository;

    @Autowired
    public RegionRepositoryImpl(RegionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Region> findAll() {

        return jpaRepository.findAll().stream()
                .map(RegionMapper::toDomain)
                .toList();
    }

    @Override
    public Region findById(int id) {

        return jpaRepository.findById(id)
                .map(RegionMapper::toDomain)
                .orElseThrow();
    }


    @Override
    public List<Region> saveAll(List<Region> regions) {
        List<RegionEntity> entities = new ArrayList<>();
        regions.forEach(domain -> entities.add(RegionMapper.toEntity(domain)));

        return jpaRepository.saveAllAndFlush(entities).stream()
                .map(RegionMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        jpaRepository.deleteAllByIdInBatch(ids);
    }
}
