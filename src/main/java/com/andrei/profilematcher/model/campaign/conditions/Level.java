package com.andrei.profilematcher.model.campaign.conditions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Level {
    private int min;
    private int max;
}
