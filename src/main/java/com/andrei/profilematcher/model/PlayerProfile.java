package com.andrei.profilematcher.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class PlayerProfile {
    @Id
    private String playerId;
    private String credential;
    private ZonedDateTime created;
    private ZonedDateTime modified;
    private ZonedDateTime lastSession;
    private int totalSpent;
    private int totalRefund;
    private int totalTransactions;
    private ZonedDateTime lastPurchase;
    @ElementCollection
    private List<String> activeCampaigns;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @ToString.Exclude
    private List<Device> devices;
    private int level;
    private int xp;
    private int totalPlaytime;
    private String country;
    private String language;
    private ZonedDateTime birthdate;
    private String gender;
    @OneToOne
    @ToString.Exclude
    private Inventory inventory;
    @OneToOne
    @ToString.Exclude
    private Clan clan;
    private String _customfield;
}
