package com.andrei.profilematcher.repository;

import com.andrei.profilematcher.model.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, String> {
}
