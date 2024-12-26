package edu.diplom.agronomistadviser.adapter.driven.repository.db.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "disease_fhb_corn")
public class DiseaseFhbCornEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @Column(name = "infection_risk", nullable = false)
    private int infectionRisk;

    public DiseaseFhbCornEntity() {
    }

    public DiseaseFhbCornEntity(long id,
                                LocalDateTime dateTime,
                                int regionId,
                                double airTemperature,
                                int relHumidity,
                                int precipitation,
                                int leafWetnessTime,
                                int infectionRisk
    ) {
        this.id = id;
        this.dateTime = dateTime;
        this.regionId = regionId;
        this.airTemperature = airTemperature;
        this.relHumidity = relHumidity;
        this.precipitation = precipitation;
        this.leafWetnessTime = leafWetnessTime;
        this.infectionRisk = infectionRisk;
    }

    public DiseaseFhbCornEntity(LocalDateTime dateTime,
                                int regionId,
                                double airTemperature,
                                int relHumidity,
                                int precipitation,
                                int leafWetnessTime,
                                int infectionRisk
    ) {
        this.dateTime = dateTime;
        this.regionId = regionId;
        this.airTemperature = airTemperature;
        this.relHumidity = relHumidity;
        this.precipitation = precipitation;
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

    public int getRelHumidity() {
        return relHumidity;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public int getLeafWetnessTime() {
        return leafWetnessTime;
    }

    public int getInfectionRisk() {
        return infectionRisk;
    }
}
