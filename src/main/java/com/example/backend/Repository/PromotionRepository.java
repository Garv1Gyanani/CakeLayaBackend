package com.example.backend.Repository;

import com.example.backend.Models.Promotion;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PromotionRepository extends MongoRepository<Promotion, String> {
    List<Promotion> findByShopId(String shopId); // Find promotions by shop ID
}
