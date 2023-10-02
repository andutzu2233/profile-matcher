package com.andrei.profilematcher;

import com.andrei.profilematcher.model.Clan;
import com.andrei.profilematcher.model.Device;
import com.andrei.profilematcher.model.Inventory;
import com.andrei.profilematcher.model.PlayerProfile;
import com.andrei.profilematcher.repository.ClanRepository;
import com.andrei.profilematcher.repository.DeviceRepository;
import com.andrei.profilematcher.repository.InventoryRepository;
import com.andrei.profilematcher.repository.PlayerProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProfileMatcherApplication implements CommandLineRunner {

    @Autowired
    private PlayerProfileRepository playerProfileRepository;
    @Autowired
    private ClanRepository clanRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProfileMatcherApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        Clan clan = new Clan();
        clan.setId(123456L);
        clan.setName("Hello world clan");
        clanRepository.save(clan);

        Device device = new Device();
        device.setId(1L);
        device.setModel("apple iphone 11");
        device.setCarrier("vodafone");
        device.setFirmware("123");
        List<Device> devices = new ArrayList<>();
        devices.add(device);
        deviceRepository.save(device);

        // Inventory
        Inventory inventory = new Inventory();
        inventory.setCash(123);
        inventory.setCoins(123);
        inventoryRepository.save(inventory);

        PlayerProfile player = new PlayerProfile();
        player.setPlayerId("97983be2-98b7-11e7-90cf-082e5f28d836");
        player.setCredential("apple_credential");
        player.setCreated(ZonedDateTime.parse("2021-01-10T13:37:17Z"));
        player.setModified(ZonedDateTime.parse("2021-01-23T13:37:17Z"));
        player.setLastSession(ZonedDateTime.parse("2021-01-23T13:37:17Z"));
        player.setTotalSpent(400);
        player.setTotalRefund(0);
        player.setTotalTransactions(5);
        player.setLastPurchase(ZonedDateTime.parse("2021-01-22T13:37:17Z"));
        player.setLevel(3);
        player.setXp(1000);
        player.setTotalPlaytime(144);
        player.setCountry("CA");
        player.setLanguage("fr");
        player.setBirthdate(ZonedDateTime.parse("2000-01-10T13:37:17Z"));
        player.setGender("male");
        player.setInventory(inventory);
        player.setDevices(devices);
        player.setClan(clan);
        player.set_customfield("mycustom");

        playerProfileRepository.save(player);
    }
}