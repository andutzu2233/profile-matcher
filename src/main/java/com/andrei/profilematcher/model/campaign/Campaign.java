package com.andrei.profilematcher.model.campaign;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Campaign {
    private String game;
    private String name;
    private double priority;
    private Matcher matchers;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private boolean enabled;
    private ZonedDateTime lastUpdated;

}