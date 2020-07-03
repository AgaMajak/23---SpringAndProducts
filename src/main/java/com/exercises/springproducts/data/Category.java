package com.exercises.springproducts.data;

public enum Category {
    FOOD("Artykuły spożywcze"),
    HOUSEHOLDS_GOODS("Artykuły gospodarstwa domowego"),
    ELSE("Inne");

    private String definition;

    Category(String definition) {
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }
}
