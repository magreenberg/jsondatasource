package com.bh.jsondatasource.controller;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Search {
    private final String target;

    @JsonCreator
    public Search(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "Search [target=" + target + "]";
    }    
    
}
