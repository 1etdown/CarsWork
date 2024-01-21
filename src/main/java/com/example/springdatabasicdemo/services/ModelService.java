package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.dtos.OfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService {

    AddModelDto createModel(AddModelDto addmodelDto);

    void deleteModel(UUID id); //

    Optional<ModelDto> find(UUID id);

    List<ShowModelDto> getAll();
    ModelDto updateModel (ModelDto modelDto);
}