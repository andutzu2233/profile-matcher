package com.andrei.profilematcher.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class PlayerProfileDTO {
    private String playerId;
    private String customField;
    private ZonedDateTime birthdate;
    private String country;
    private ZonedDateTime created;
    private String credential;
    private String gender;
    private Long clanId;
    private String clanName;
    private String language;
    private ZonedDateTime lastPurchase;
    private ZonedDateTime lastSession;
    private int level;
    private ZonedDateTime modified;
    private int totalPlaytime;
    private int totalRefund;
    private int totalSpent;
    private int totalTransactions;
    private int xp;
    private Long inventoryId;
    private int cash;
    private int coins;
    private List<String> activeCampaigns;

}
