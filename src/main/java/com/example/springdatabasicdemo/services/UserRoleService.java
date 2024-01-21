package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRoleService {

    UserRoleDto createUserRole(UserRoleDto offerDto);

    void deleteUserRole(UUID id); //

    Optional<UserRoleDto> find(UUID id);

    List<UserRoleDto> getAll();
    UserRoleDto updateUserRole (UserRoleDto userRoleDto);
}