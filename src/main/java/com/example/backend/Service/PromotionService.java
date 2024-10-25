package com.example.backend.Service;

import com.example.backend.Models.Promotion;
import com.example.backend.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getPromotionsByShopId(String shopId) {
        return promotionRepository.findByShopId(shopId);
    }

    public Promotion createPromotion(Promotion promotion) {
        promotion.setCreatedAt(String.valueOf(System.currentTimeMillis()));
        return promotionRepository.save(promotion);
    }
}
