package com.andrei.profilematcher.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cash;
    private int coins;
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<Item> items;
}
