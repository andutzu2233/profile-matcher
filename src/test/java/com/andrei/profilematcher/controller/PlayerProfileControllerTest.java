package com.andrei.profilematcher.controller;

import com.andrei.profilematcher.dto.PlayerProfileDTO;
import com.andrei.profilematcher.service.PlayerProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PlayerProfileControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PlayerProfileService playerProfileService;

    @InjectMocks
    private PlayerProfileController playerProfileController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerProfileController).build();
    }

    @Test
    void testGetClientConfig_MatchFound() throws Exception {
        PlayerProfileDTO profileDTO = new PlayerProfileDTO();
        String playerId = "somePlayerId";

        when(playerProfileService.matchProfileWithCampaign(playerId)).thenReturn(Optional.of(profileDTO));

        mockMvc.perform(get("/get_client_config/" + playerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetClientConfig_NoMatchFound() throws Exception {
        String playerId = "somePlayerId";
        when(playerProfileService.matchProfileWithCampaign(playerId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/get_client_config/" + playerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
