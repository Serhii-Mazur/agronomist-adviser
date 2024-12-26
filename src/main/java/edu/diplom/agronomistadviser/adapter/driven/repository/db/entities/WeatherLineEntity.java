package edu.diplom.agronomistadviser.adapter.driven.repository.db.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//@Entity
public class WeatherLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "avg_air_temp", nullable = false)
    private float avgAirTemperature;

    @Column(name = "rel_humidity", nullable = false)
    private int relHumidity;

    @Column(name = "precipitation", nullable = false)
    private float precipitation;

    @Column(name = "leaf_wetness", nullable = false)
    private int leafWetness;
}
