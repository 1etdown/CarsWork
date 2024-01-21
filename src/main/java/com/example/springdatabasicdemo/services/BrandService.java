package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.dtos.ModelDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {

    AddBrandDto createBrand(AddBrandDto addBrandDto);

    void deleteBrand(UUID id); //

    Optional<ShowBrandDto> find(UUID id);

    List<ShowBrandDto> getAll();
    BrandDto updateBrand (BrandDto brandDto);
}