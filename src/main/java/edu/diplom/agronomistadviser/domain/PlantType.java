package edu.diplom.agronomistadviser.domain;

public enum PlantType {
    CORN("Corn"),
    WHEAT("Wheat"),
    SUNFLOWER("Sunflower");

    public final String description;

    PlantType(String description) {
        this.description = description;
    }
}
