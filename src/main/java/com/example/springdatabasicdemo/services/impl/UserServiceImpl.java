package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    @Autowired
    public void setUserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Autowired
    public void setUserRepository( UserRepository  userRepository){
        this. userRepository =  userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = modelMapper.map(userDto, Users.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> find(UUID id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            return Optional.of(modelMapper.map(user.get(), UserDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<UserDto> getAll() {
        List<Users> offers = userRepository.findAll();
        return offers.stream()
                .map(offer -> modelMapper.map(offer, UserDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public UserDto updateUser(UserDto user) {
            return modelMapper.map(userRepository.save(modelMapper.map(user, Users.class)), UserDto.class);
    }
    @Override
    public Optional<UserDto> findByUserName(String username) {
        Optional<Users> user = userRepository.findByUserName(username);
        if (user.isPresent()) {
            return Optional.of(modelMapper.map(user.get(), UserDto.class));
        }
        return Optional.empty();
    }
    @Override
    public Optional<UserDto> findUserByUserName(Users username) {
        Optional<Users> user = userRepository.findUserByUserName(username);
        if (user.isPresent()) {
            return Optional.of(modelMapper.map(user.get(), UserDto.class));
        }
        return Optional.empty();
    }

}