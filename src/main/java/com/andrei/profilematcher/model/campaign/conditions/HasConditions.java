package com.andrei.profilematcher.model.campaign.conditions;

import lombok.Data;

import java.util.List;

@Data
public class HasConditions {
    private List<String> countries;
    private List<String> items;
}
