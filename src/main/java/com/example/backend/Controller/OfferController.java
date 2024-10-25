package com.example.backend.Controller;

import com.example.backend.Models.Offer;
import com.example.backend.Repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/shops/{shopId}/offers")
public class OfferController {

    @Autowired
    private OfferRepository offerRepo;

    // Create a new offer for a specific shop
    @PostMapping
    public ResponseEntity<Offer> createOffer(@PathVariable String shopId, @RequestBody Offer offer) {
        // Set the shopId in the offer
        offer.setShopId(shopId);
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        offer.setCreatedAt(currentTime);

        try {
            Offer savedOffer = offerRepo.save(offer);
            return new ResponseEntity<>(savedOffer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Retrieve all offers for a specific shop
    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers(@PathVariable String shopId) {
        List<Offer> offers = offerRepo.findByShopId(shopId);
        if (offers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    // Retrieve a specific offer by offerId
    @GetMapping("/{offerId}")
    public ResponseEntity<Offer> getOfferById(@PathVariable String shopId, @PathVariable String offerId) {
        return offerRepo.findById(offerId)
                .filter(offer -> offer.getShopId().equals(shopId))
                .map(offer -> new ResponseEntity<>(offer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add more methods as needed, such as updating or deleting offers...
}
