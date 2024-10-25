package com.example.backend.Repository;

import com.example.backend.Models.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OfferRepository extends MongoRepository<Offer, String> {
    List<Offer> findByShopId(String shopId); // Find offers by shopId
}
