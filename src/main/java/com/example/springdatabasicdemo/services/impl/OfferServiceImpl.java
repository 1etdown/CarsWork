package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class OfferServiceImpl implements OfferService {

    private ModelMapper modelMapper;
    private OfferRepository offerRepository;
    private final UserRepository userRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository usersRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = usersRepository;
        this.modelMapper = modelMapper;

    }



    @Override
    public void createOffer(AddOfferDto offer) {
        Offer of = modelMapper.map(offer, Offer.class);
        of.setUser(userRepository.findByUserName(offer.getUser()).orElse(null));
        offerRepository.saveAndFlush(of);
    }



    @CacheEvict(cacheNames = "offer", allEntries = true)
    public void addOffer(AddOfferDto offer) {
        Offer of = modelMapper.map(offer, Offer.class);
        of.setUser(userRepository.findByUserName(offer.getUser()).orElse(null));
        offerRepository.saveAndFlush(of);
    }
    @Override
    @CacheEvict(cacheNames = "offer", allEntries = true)
    public void deleteOffer(UUID id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Optional<OfferDto> find(UUID id) {
        Optional<Offer> offer = offerRepository.findById(id);
        if (offer.isPresent()) {
            return Optional.of(modelMapper.map(offer.get(), OfferDto.class));
        }
        return Optional.empty();
    }


    @Cacheable("offer")
    public List<ShowOfferDto> getAll() {
        List<Offer> offers = offerRepository.findAll();
        return offers.stream()
                .map(offer -> modelMapper.map(offer, ShowOfferDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public OfferDto updateOffer(OfferDto offer) {
        return modelMapper.map(offerRepository.save(modelMapper.map(offer, Offer.class)), OfferDto.class);
    }
    public ShowDetaildOfferDto offerDetails(UUID offerId) {
        return modelMapper.map(offerRepository.findById(offerId).orElse(null), ShowDetaildOfferDto.class);
    }
    @Override
    public List<ShowOfferDto> getByPriceRange(Double minPrice, Double maxPrice) {
        List<Offer> offers = offerRepository.findByPriceBetween(minPrice, maxPrice);
        return offers.stream()
                .map(offer -> modelMapper.map(offer, ShowOfferDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<ShowOfferDto> getAllSortedByPriceAsc() {
        List<Offer> offers = offerRepository.findAllByOrderByPriceAsc();
        return mapToDtoList(offers);
    }

    @Override
    public List<ShowOfferDto> getAllSortedByPriceDesc() {
        List<Offer> offers = offerRepository.findAllByOrderByPriceDesc();
        return mapToDtoList(offers);
    }

    private List<ShowOfferDto> mapToDtoList(List<Offer> offers) {
        return offers.stream()
                .map(offer -> modelMapper.map(offer, ShowOfferDto.class))
                .collect(Collectors.toList());
    }




}