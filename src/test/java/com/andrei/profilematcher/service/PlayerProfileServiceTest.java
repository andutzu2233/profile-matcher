package com.andrei.profilematcher.service;

import com.andrei.profilematcher.dto.PlayerProfileDTO;
import com.andrei.profilematcher.model.PlayerProfile;
import com.andrei.profilematcher.model.campaign.Campaign;
import com.andrei.profilematcher.model.campaign.Matcher;
import com.andrei.profilematcher.model.campaign.conditions.HasConditions;
import com.andrei.profilematcher.repository.PlayerProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlayerProfileServiceTest {

    @InjectMocks
    private PlayerProfileService playerProfileService;

    @Mock
    private PlayerProfileRepository playerProfileRepository;

    @Mock
    private MockCampaignApiService mockCampaignApiService;


    @Test
    void testGetCurrentCampaign() {
        Campaign expectedCampaign = new Campaign();
        when(mockCampaignApiService.getCurrentCampaign()).thenReturn(expectedCampaign);

        Campaign result = playerProfileService.getCurrentCampaign();
        assertEquals(expectedCampaign, result);
    }

    @Test
    void testMatchProfileWithCampaign_MatchFound() {
        String playerId = "somePlayerId";
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setCountry("someCountry");

        Campaign currentCampaign = new Campaign();
        Matcher matcher = new Matcher();
        HasConditions has = new HasConditions();
        has.setCountries(List.of("someCountry"));
        matcher.setHas(has);
        currentCampaign.setMatchers(matcher);
        playerProfile.setActiveCampaigns(new ArrayList<>());

        when(playerProfileRepository.findById(playerId)).thenReturn(Optional.of(playerProfile));
        when(mockCampaignApiService.getCurrentCampaign()).thenReturn(currentCampaign);

        Optional<PlayerProfileDTO> result = playerProfileService.matchProfileWithCampaign(playerId);

        assertTrue(result.isPresent());
    }

    @Test
    void testMatchProfileWithCampaign_NoMatch() {
        String playerId = "somePlayerId";
        when(playerProfileRepository.findById(playerId)).thenReturn(Optional.empty());

        Optional<PlayerProfileDTO> result = playerProfileService.matchProfileWithCampaign(playerId);

        assertFalse(result.isPresent());
    }
}
