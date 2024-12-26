package edu.diplom.agronomistadviser.application.port.repository.db;

import edu.diplom.agronomistadviser.domain.Region;

import java.util.List;

public interface RegionRepository {
    List<Region> findAll();

    List<Region> saveAll(List<Region> regions);

    Region findById(int id);

    void deleteByIds(List<Integer> ids);
}
