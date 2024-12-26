package edu.diplom.agronomistadviser.adapter.driven.repository.db.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "disease_lbh_corn")
public class DiseaseLbhCornEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "region_id", nullable = false)
    private int regionId;

    @Column(name = "air_temperature", nullable = false)
    private double airTemperature;

    @Column(name = "rel_humidity", nullable = false)
    private int relHumidity;

    @Column(name = "precipitation", nullable = false)
    private int precipitation;

    @Column(name = "leaf_wetness_time", nullable = false)
    private int leafWetnessTime;

    @Column(name = "south_clb_infection_risk", nullable = false)
    private int southClbInfectionRisk;

    @Column(name = "north_clb_infection_risk", nullable = false)
    private int northClbInfectionRisk;

    public DiseaseLbhCornEntity() {
    }

    public DiseaseLbhCornEntity(long id,
                                LocalDateTime dateTime,
                                int regionId,
                                double airTemperature,
                                int relHumidity,
                                int precipitation,
                                int leafWetnessTime,
                                int southClbInfectionRisk,
                                int northClbInfectionRisk
    ) {
        this.id = id;
        this.dateTime = dateTime;
        this.regionId = regionId;
        this.airTemperature = airTemperature;
        this.relHumidity = relHumidity;
        this.precipitation = precipitation;
        this.leafWetnessTime = leafWetnessTime;
        this.southClbInfectionRisk = southClbInfectionRisk;
        this.northClbInfectionRisk = northClbInfectionRisk;
    }

    public DiseaseLbhCornEntity(LocalDateTime dateTime,
                                int regionId,
                                double airTemperature,
                                int relHumidity,
                                int precipitation,
                                int leafWetnessTime,
                                int southClbInfectionRisk,
                                int northClbInfectionRisk
    ) {
        this.dateTime = dateTime;
        this.regionId = regionId;
        this.airTemperature = airTemperature;
        this.relHumidity = relHumidity;
        this.precipitation = precipitation;
        this.leafWetnessTime = leafWetnessTime;
        this.southClbInfectionRisk = southClbInfectionRisk;
        this.northClbInfectionRisk = northClbInfectionRisk;
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

    public int getRelHumidity() {
        return relHumidity;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public int getLeafWetnessTime() {
        return leafWetnessTime;
    }

    public int getSouthClbInfectionRisk() { return southClbInfectionRisk; }

    public int getNorthClbInfectionRisk() { return northClbInfectionRisk; }

}
