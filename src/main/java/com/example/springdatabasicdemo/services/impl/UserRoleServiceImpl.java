package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private ModelMapper modelMapper;
    private UserRoleRepository  userRoleRepository;
    @Autowired
    public void setUserRoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Autowired
    public void setUserRoleRepository( UserRoleRepository  userRoleRepository){
        this. userRoleRepository =  userRoleRepository;
    }

    @Override
    public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
        UserRole userRole = modelMapper.map(userRoleDto, UserRole.class);
        return modelMapper.map(userRoleRepository.save(userRole), UserRoleDto.class);
    }

    @Override
    public void deleteUserRole(UUID id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public Optional<UserRoleDto> find(UUID id) {
        Optional<UserRole> userRole = userRoleRepository.findById(id);
        if (userRole.isPresent()) {
            return Optional.of(modelMapper.map(userRole.get(), UserRoleDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<UserRoleDto> getAll() {
        List<UserRole> offers = userRoleRepository.findAll();
        return offers.stream()
                .map(offer -> modelMapper.map(offer, UserRoleDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public UserRoleDto updateUserRole(UserRoleDto userRole) {
        return modelMapper.map(userRoleRepository.save(modelMapper.map(userRole, UserRole.class)), UserRoleDto.class);
    }

}