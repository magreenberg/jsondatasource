package com.bh.jsondatasource.controller;
import com.fasterxml.jackson.annotation.JsonCreator;
public class Target {
    private final String refId; //=A
    private final String data;
    private final String target;
    private final String type; //=table
    private final String datasource; //=JSON

    @JsonCreator
	public Target(String refId, String data, String target, String type, String datasource) {
		this.refId = refId;
		this.data = data;
		this.target = target;
		this.type = type;
		this.datasource = datasource;
	}

    public String getRefId() {
        return refId;
    }

    public String getData() {
        return data;
    }

    public String getTarget() {
        return target;
    }

    public String getType() {
        return type;
    }

    public String getDatasource() {
        return datasource;
    }

    @Override
    public String toString() {
        return "Target [data=" + data + ", datasource=" + datasource + ", refId=" + refId + ", target=" + target
                + ", type=" + type + "]";
    }
    
}
