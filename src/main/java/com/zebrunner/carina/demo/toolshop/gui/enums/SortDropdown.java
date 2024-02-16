package com.zebrunner.carina.demo.toolshop.gui.enums;


public enum SortDropdown {
    LOW_TO_HIGH("Price (Low - High)"),
    HIGH_TO_LOW("Price (High - Low)");

    private String sortType;

    SortDropdown(String sortType) {
        this.sortType = sortType;

    }

    public String getSortType() {
        return sortType;
    }
}
