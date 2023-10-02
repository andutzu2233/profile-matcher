package com.andrei.profilematcher.model.campaign.conditions;

import lombok.Data;

import java.util.List;

@Data
public class DoesNotHaveConditions {
    private List<String> items;
}
