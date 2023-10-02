package com.andrei.profilematcher.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

}
