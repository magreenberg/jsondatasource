package com.bh.jsondatasource.controller;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Range {
    private final String from;
    private final String to;
    private final RangeRaw raw;

    @JsonCreator
    public Range(String from, String to, RangeRaw raw) {
        this.from = from;
        this.to = to;
        this.raw = raw;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public RangeRaw getRaw() {
        return raw;
    }

    @Override
    public String toString() {
        return "Range [from=" + from + ", raw=" + raw + ", to=" + to + "]";
    }
    
}