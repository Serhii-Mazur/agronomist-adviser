package edu.diplom.agronomistadviser.adapter.driven.repository.db.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "regions")
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public RegionEntity() {
    }

    public RegionEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public RegionEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
