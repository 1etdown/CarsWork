package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.AddOfferDto;
import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.dtos.ShowDetaildOfferDto;
import com.example.springdatabasicdemo.dtos.ShowOfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {
    List<ShowOfferDto> getTwoOffers();
    void createOffer(AddOfferDto offer);

    void addOffer(AddOfferDto offer);

    void deleteOffer(UUID id);

    Optional<OfferDto> find(UUID id);

    List<ShowOfferDto> getAll();

    OfferDto updateOffer(OfferDto offer);

  ShowDetaildOfferDto offerDetails(UUID id);

    List<ShowOfferDto> getByPriceRange(Double minPrice, Double maxPrice);

    List<ShowOfferDto> getAllSortedByPriceAsc();

    List<ShowOfferDto> getAllSortedByPriceDesc();
}
