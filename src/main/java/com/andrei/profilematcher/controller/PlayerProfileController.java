package com.andrei.profilematcher.controller;

import com.andrei.profilematcher.dto.PlayerProfileDTO;
import com.andrei.profilematcher.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlayerProfileController {
    @Autowired
    private PlayerProfileService playerProfileService;

    @GetMapping("/get_client_config/{player_id}")
    public ResponseEntity<PlayerProfileDTO> getClientConfig(@PathVariable String player_id) {
        Optional<PlayerProfileDTO> matchedProfile = playerProfileService.matchProfileWithCampaign(player_id);
        return matchedProfile.map(playerProfile
                -> new ResponseEntity<>(playerProfile, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
