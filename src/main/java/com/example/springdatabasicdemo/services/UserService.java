package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDto;

import com.example.springdatabasicdemo.models.Users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserDto createUser(UserDto userDto);

    void deleteUser(UUID id); //

    Optional<UserDto> find(UUID id);

    List<UserDto> getAll();
    UserDto updateUser (UserDto userDto);
    Optional<UserDto> findByUserName(String username);
    Optional<UserDto> findUserByUserName(Users username);
}