package com.example.backend.Controller;

import com.example.backend.Models.Promotion;
import com.example.backend.Service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Promotion>> getPromotionsByShopId(@PathVariable String shopId) {
        List<Promotion> promotions = promotionService.getPromotionsByShopId(shopId);
        return ResponseEntity.ok(promotions);
    }

    @PostMapping("/shop/{shopId}")
    public ResponseEntity<Promotion> createPromotion(@PathVariable String shopId, @RequestBody Promotion promotion) {
        promotion.setShopId(shopId); 
        Promotion createdPromotion = promotionService.createPromotion(promotion);
        return ResponseEntity.ok(createdPromotion);
    }
}
