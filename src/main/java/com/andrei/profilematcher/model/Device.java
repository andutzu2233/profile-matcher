package com.andrei.profilematcher.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private String carrier;
    private String firmware;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerProfile player;
}




