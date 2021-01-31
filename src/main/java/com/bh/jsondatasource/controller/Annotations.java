package com.bh.jsondatasource.controller;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Annotations {
    private final Annotation annotation;
    private final Range range;
    private final RangeRaw rangeRaw;

    @JsonCreator
    public Annotations(Annotation annotation, Range range, RangeRaw rangeRaw) {
        this.annotation = annotation;
        this.range = range;
        this.rangeRaw = rangeRaw;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public Range getRange() {
        return range;
    }

    public RangeRaw getRangeRaw() {
        return rangeRaw;
    }

    @Override
    public String toString() {
        return "Annotations [annotation=" + annotation.toString() + ", range=" + range + ", rangeRaw=" + rangeRaw.toString() + "]";
    }

}