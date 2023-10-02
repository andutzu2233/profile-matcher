package com.andrei.profilematcher.service;

import com.andrei.profilematcher.dto.PlayerProfileDTO;
import com.andrei.profilematcher.model.PlayerProfile;
import com.andrei.profilematcher.model.campaign.Campaign;
import com.andrei.profilematcher.repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerProfileService {

    @Autowired
    private PlayerProfileRepository playerProfileRepository;
    @Autowired
    private MockCampaignApiService mockCampaignApiService;

    public Campaign getCurrentCampaign() {
        return mockCampaignApiService.getCurrentCampaign();
    }

    public Optional<PlayerProfileDTO> matchProfileWithCampaign(String playerId) {
        Optional<PlayerProfile> profile = playerProfileRepository.findById(playerId);
        if (profile.isPresent()) {
            PlayerProfile playerProfile = profile.get();
            Campaign currentCampaign = getCurrentCampaign();
            if (currentCampaign.getMatchers().getHas().getCountries().contains(playerProfile.getCountry())
                    || (playerProfile.getLevel() >= currentCampaign.getMatchers().getLevel().getMin()
                    && playerProfile.getLevel() <= currentCampaign.getMatchers().getLevel().getMax())) {
                playerProfile.getActiveCampaigns().add(currentCampaign.getName());
                playerProfileRepository.save(playerProfile);
                return Optional.of(toDTO(playerProfile));
            }
        }
        return Optional.empty();
    }

    private PlayerProfileDTO toDTO(PlayerProfile playerProfile) {
        PlayerProfileDTO dto = new PlayerProfileDTO();

        dto.setPlayerId(playerProfile.getPlayerId());
        dto.setCustomField(playerProfile.get_customfield());
        dto.setBirthdate(playerProfile.getBirthdate());
        dto.setCountry(playerProfile.getCountry());
        dto.setCreated(playerProfile.getCreated());
        dto.setCredential(playerProfile.getCredential());
        dto.setGender(playerProfile.getGender());

        if (playerProfile.getClan() != null) {
            dto.setClanId(playerProfile.getClan().getId());
            dto.setClanName(playerProfile.getClan().getName());
        }

        dto.setLanguage(playerProfile.getLanguage());
        dto.setLastPurchase(playerProfile.getLastPurchase());
        dto.setLastSession(playerProfile.getLastSession());
        dto.setLevel(playerProfile.getLevel());
        dto.setModified(playerProfile.getModified());
        dto.setTotalPlaytime(playerProfile.getTotalPlaytime());
        dto.setTotalRefund(playerProfile.getTotalRefund());
        dto.setTotalSpent(playerProfile.getTotalSpent());
        dto.setTotalTransactions(playerProfile.getTotalTransactions());
        dto.setXp(playerProfile.getXp());

        if (playerProfile.getInventory() != null) {
            dto.setInventoryId(playerProfile.getInventory().getId());
            dto.setCash(playerProfile.getInventory().getCash());
            dto.setCoins(playerProfile.getInventory().getCoins());
        }

        dto.setActiveCampaigns(playerProfile.getActiveCampaigns());

        return dto;
    }
}
