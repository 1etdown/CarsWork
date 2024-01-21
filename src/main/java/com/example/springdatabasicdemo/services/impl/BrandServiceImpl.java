package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private ModelMapper modelMapper;
    private BrandRepository brandRepository;
    @Autowired
    public void setBrandModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Autowired
    public void setBrandRepository(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
    @Override
    public AddBrandDto createBrand(AddBrandDto addbrandDto) {
        Brand brand = modelMapper.map(addbrandDto, Brand.class);
        return modelMapper.map(brandRepository.save(brand), AddBrandDto.class);
    }


    @Override
    public void deleteBrand(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Optional<ShowBrandDto> find(UUID id) {
        Optional<Brand> Brand = brandRepository.findById(id);
        if (Brand.isPresent()) {
            return Optional.of(modelMapper.map(Brand.get(), ShowBrandDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<ShowBrandDto> getAll() {
        List<Brand> Brands = brandRepository.findAll();
        return Brands.stream()
                .map(Brand -> modelMapper.map(Brand, ShowBrandDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public BrandDto updateBrand(BrandDto brand) {
        return modelMapper.map(brandRepository.save(modelMapper.map(brand, Brand.class)), BrandDto.class);
    }

}