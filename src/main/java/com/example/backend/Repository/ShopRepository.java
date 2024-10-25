package com.example.backend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend.Models.Shop;

public interface ShopRepository extends MongoRepository<Shop, String> { 

}
