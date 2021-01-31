package com.bh.jsondatasource.controller;

import com.fasterxml.jackson.annotation.JsonCreator;

public class RangeRaw {
    private final String from;
    private final String to;

    @JsonCreator
	public RangeRaw(String from, String to) {
		this.from = from;
		this.to = to;
	}

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "RangeRaw [from=" + from + ", to=" + to + "]";
    }

}
