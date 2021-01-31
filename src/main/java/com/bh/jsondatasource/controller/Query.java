package com.bh.jsondatasource.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;

public class Query {
    private final String app;
    private final String requestId; // =Q116,
    private final String timezone; // =browser,
    private final String panelId; // =2,
    private final String dashboardId; // =null,
    private final Range range; //={from=2021-01-31T06:01:27.153Z, to=2021-01-31T12:01:27.153Z, raw={from=now-6h, to=now}},
    // timeInfo=,
    private final String interval; // =30s,
    private final long intervalMs; // =30000,
    private final List<Target> targets; // targets=[{refId=A, data=, target=, type=table, datasource=JSON}],
    private final String maxDataPoints; // =593,
    // scopedVars={__interval={text=30s, value=30s}, __interval_ms={text=30000,
    // value=30000}},
    private final String startTime; // =1612094487153,
    private final RangeRaw rangeRaw; //={from=now-6h, to=now},
    // adhocFilters=[]

    @JsonCreator
    public Query(String app, String requestId, String timezone, String panelId, String dashboardId, Range range, String interval,
            long intervalMs, List<Target> targets, String maxDataPoints, String startTime, RangeRaw rangeRaw) {
        this.app = app;
        this.requestId = requestId;
        this.timezone = timezone;
        this.panelId = panelId;
        this.dashboardId = dashboardId;
        this.range = range;
        this.interval = interval;
        this.intervalMs = intervalMs;
        this.targets = targets;
        this.maxDataPoints = maxDataPoints;
        this.startTime = startTime;
        this.rangeRaw = rangeRaw;
    }

    public String getApp() {
        return app;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getPanelId() {
        return panelId;
    }

    public String getDashboardId() {
        return dashboardId;
    }

    public Range getRange() {
        return range;
    }

    public String getInterval() {
        return interval;
    }

    public long getIntervalMs() {
        return intervalMs;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public String getMaxDataPoints() {
        return maxDataPoints;
    }

    public String getStartTime() {
        return startTime;
    }

    public RangeRaw rangeRaw() {
        return rangeRaw;
    }

    @Override
    public String toString() {
        return "Query [app=" + app + ", dashboardId=" + dashboardId + ", interval=" + interval + ", intervalMs="
                + intervalMs + ", maxDataPoints=" + maxDataPoints + ", panelId=" + panelId + ", range=" + range
                + ", rangeRaw=" + rangeRaw.toString() + ", requestId=" + requestId + ", startTime=" + startTime + ", targets="
                + targets + ", timezone=" + timezone + "]";
    }

}