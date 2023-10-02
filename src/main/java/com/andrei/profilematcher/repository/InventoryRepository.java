package com.andrei.profilematcher.repository;

import com.andrei.profilematcher.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
