package edu.diplom.agronomistadviser.adapter.driven.repository.db.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "disease_pmb_wheat")
public class DiseasePmbWheatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "region_id", nullable = false)
    private int regionId;

    @Column(name = "air_temperature", nullable = false)
    private double airTemperature;

    @Column(name = "solar_radiation", nullable = false)
    private int solarRadiation;

    @Column(name = "leaf_wetness_time", nullable = false)
    private int leafWetnessTime;

    @Column(name = "infection_risk", nullable = false)
    private int infectionRisk;

    public DiseasePmbWheatEntity() {
    }

    public DiseasePmbWheatEntity(long id,
                                 LocalDateTime dateTime,
                                 int regionId,
                                 double airTemperature,
                                 int solarRadiation,
                                 int leafWetnessTime,
                                 int infectionRisk
    ) {
        this.id = id;
        this.dateTime = dateTime;
        this.regionId = regionId;
        this.airTemperature = airTemperature;
        this.solarRadiation = solarRadiation;
        this.leafWetnessTime = leafWetnessTime;
        this.infectionRisk = infectionRisk;
    }

    public DiseasePmbWheatEntity(LocalDateTime dateTime,
                                 int regionId,
                                 double airTemperature,
                                 int solarRadiation,
                                 int leafWetnessTime,
                                 int infectionRisk
    ) {
        this.dateTime = dateTime;
        this.regionId = regionId;
        this.airTemperature = airTemperature;
        this.solarRadiation = solarRadiation;
        this.leafWetnessTime = leafWetnessTime;
        this.infectionRisk = infectionRisk;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getRegionId() {
        return regionId;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public int getSolarRadiation() {
        return solarRadiation;
    }

    public int getLeafWetnessTime() {
        return leafWetnessTime;
    }

    public int getInfectionRisk() {
        return infectionRisk;
    }
}
