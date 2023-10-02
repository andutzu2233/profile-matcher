package com.andrei.profilematcher.repository;

import com.andrei.profilematcher.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
