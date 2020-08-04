package com.exercises.springproducts.data;

public enum Category {
    FOOD("Artykuły spożywcze"),
    HOUSEHOLDS_GOODS("Artykuły gospodarstwa domowego"),
    ELSE("Inne");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}