package edu.diplom.agronomistadviser.domain;

public enum DiseaseType {
    FHB("Fusarium Head Blight"),            // Fusarium Head Blight (corn)
    LBH("Leaf Blight Helminthosporium"),    // Leaf Blight Helminthosporium turcicum (corn)
    PMB("Powdery Mildew Blumeria"),         // Powdery Mildew Blumeria graminis (wheat)
    GMD("Grey Mould");                      // Grey Mould risk for damages caused by Botrytis cinerea (sunflower)

    public final String description;

    DiseaseType(String description) {
        this.description = description;
    }
}

