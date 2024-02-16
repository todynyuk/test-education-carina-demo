package com.zebrunner.carina.demo.toolshop.gui.enums;

public enum  ByCategoty {
    HAMMER(" Hammer"),
    PLIERS(" Pliers");

    private String category;

    ByCategoty(String category) {
        this.category = category;

    }

    public String getCategory() {
        return category;
    }
}
