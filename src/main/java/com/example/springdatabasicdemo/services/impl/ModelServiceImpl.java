package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private ModelMapper modelMapper;
    private ModelRepository modelRepository;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Autowired
    public void setModelRepository(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }
    @Override
    public AddModelDto createModel(AddModelDto addmodelDto) {
        Model model = modelMapper.map(addmodelDto, Model.class);
        return modelMapper.map(modelRepository.save(model), AddModelDto.class);
    }

    @Override
    public void deleteModel(UUID id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Optional<ModelDto> find(UUID id) {
        Optional<Model> model = modelRepository.findById(id);
        if (model.isPresent()) {
            return Optional.of(modelMapper.map(model.get(), ModelDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<ShowModelDto> getAll() {
        List<Model> models = modelRepository.findAll();
        return models.stream()
                .map(model -> modelMapper.map(model, ShowModelDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public ModelDto updateModel(ModelDto model) {
        return modelMapper.map(modelRepository.save(modelMapper.map(model, Model.class)), ModelDto.class);
    }

}