package com.bh.jsondatasource.controller;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Annotation {
    private final String query;
    private final String name;
    private final String datasource;
    private final Boolean enable;
    private final String iconColor;

    @JsonCreator
    public Annotation(String query, String name, String datasource, Boolean enable, String iconColor) {
        this.query = query;
        this.name = name;
        this.datasource = datasource;
        this.enable = enable;
        this.iconColor = iconColor;
    }

    public String getQuery() {
        return query;
    }

    public String getName() {
        return name;
    }

    public String getDatasource() {
        return datasource;
    }

    public Boolean getEnable() {
        return enable;
    }

    public String getIconColor() {
        return iconColor;
    }

    

    
}
