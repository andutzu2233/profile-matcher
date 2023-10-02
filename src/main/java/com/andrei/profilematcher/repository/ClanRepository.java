package com.andrei.profilematcher.repository;

import com.andrei.profilematcher.model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<Clan, Long> {
}
