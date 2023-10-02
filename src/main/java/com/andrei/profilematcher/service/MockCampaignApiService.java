package com.andrei.profilematcher.service;

import com.andrei.profilematcher.model.campaign.Campaign;
import com.andrei.profilematcher.model.campaign.Matcher;
import com.andrei.profilematcher.model.campaign.conditions.DoesNotHaveConditions;
import com.andrei.profilematcher.model.campaign.conditions.HasConditions;
import com.andrei.profilematcher.model.campaign.conditions.Level;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class MockCampaignApiService {
    public Campaign getCurrentCampaign() {
        Campaign mockCampaign = new Campaign();
        mockCampaign.setGame("mygame");
        mockCampaign.setName("mycampaign");
        mockCampaign.setPriority(10.5);
        mockCampaign.setStartDate(ZonedDateTime.parse("2022-01-25T00:00:00Z"));
        mockCampaign.setEndDate(ZonedDateTime.parse("2022-02-25T00:00:00Z"));
        mockCampaign.setEnabled(true);
        mockCampaign.setLastUpdated(ZonedDateTime.parse("2021-07-13T11:46:58Z"));

        Matcher matchers = new Matcher();
        matchers.setLevel(new Level(1, 3));

        HasConditions has = new HasConditions();
        has.setCountries(Arrays.asList("US", "RO", "CA"));
        has.setItems(List.of("item_1"));
        matchers.setHas(has);

        DoesNotHaveConditions doesNotHave = new DoesNotHaveConditions();
        doesNotHave.setItems(List.of("item_4"));
        matchers.setDoesNotHave(doesNotHave);

        mockCampaign.setMatchers(matchers);

        return mockCampaign;
    }
}

