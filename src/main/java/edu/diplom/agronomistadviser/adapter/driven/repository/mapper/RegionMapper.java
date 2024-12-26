package edu.diplom.agronomistadviser.adapter.driven.repository.mapper;

import edu.diplom.agronomistadviser.adapter.driven.repository.db.entities.RegionEntity;
import edu.diplom.agronomistadviser.domain.Region;

public class RegionMapper {

    public static Region toDomain(RegionEntity entity) {

        return new Region(entity.getId(), entity.getName(), entity.getDescription());
    }

    public static RegionEntity toEntity(Region domain) {
        return new RegionEntity(domain.id(), domain.name(), domain.description());
    }
}
