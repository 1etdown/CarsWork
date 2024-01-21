package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.dtos.ShowOfferDto;
import com.example.springdatabasicdemo.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    List<Offer> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Offer> findAllByOrderByPriceAsc();
    List<Offer> findAllByOrderByPriceDesc();

}
