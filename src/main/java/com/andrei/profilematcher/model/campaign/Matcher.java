package com.andrei.profilematcher.model.campaign;

import com.andrei.profilematcher.model.campaign.conditions.DoesNotHaveConditions;
import com.andrei.profilematcher.model.campaign.conditions.HasConditions;
import com.andrei.profilematcher.model.campaign.conditions.Level;
import lombok.Data;

@Data
public class Matcher {
    private Level level;
    private HasConditions has;
    private DoesNotHaveConditions doesNotHave;
}
