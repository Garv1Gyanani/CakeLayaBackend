package com.example.backend.Controller;

import com.example.backend.Models.Shop;
import com.example.backend.Repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopRepository shopRepo;

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        if (shop.getShopName() == null || shop.getShopName().isEmpty() || 
            shop.getFssaiLicenseNumber() == null || shop.getFssaiLicenseNumber().isEmpty() || 
            shop.getCommissionPercentage() == null || shop.getCommissionPercentage() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        shop.setCreatedAt(currentTime);
        shop.setUpdatedAt(currentTime);

        try {
            Shop savedShop = shopRepo.save(shop);
            return new ResponseEntity<>(savedShop, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/current/id") 
    public ResponseEntity<Map<String, String>> getCurrentShopId() {
        List<Shop> shops = shopRepo.findAll();
        if (shops.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Shop currentShop = shops.get(shops.size() - 1);
        Map<String, String> response = new HashMap<>();
        response.put("id", currentShop.getId()); 
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Shop> getShopById(@PathVariable String id) {
        return shopRepo.findById(id)
            .map(shop -> new ResponseEntity<>(shop, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Shop> getAllShops() {
        return shopRepo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable String id, @RequestBody Shop shopDetails) {
        return shopRepo.findById(id)
            .map(shop -> {
                shop.setShopName(shopDetails.getShopName());
                shop.setFssaiLicenseNumber(shopDetails.getFssaiLicenseNumber());
                shop.setCommissionPercentage(shopDetails.getCommissionPercentage());
                shop.setShopPhotoUrl(shopDetails.getShopPhotoUrl());
                shop.setPackagingDelivery(shopDetails.getPackagingDelivery());
                shop.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                return new ResponseEntity<>(shopRepo.save(shop), HttpStatus.OK);
            }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
