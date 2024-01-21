package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enums.Role;

import java.util.UUID;

public class UserRoleDto {

    private UUID id;
    private Role role;

    public UserRoleDto(UUID id, Role role) {
        this.id = id;
        this.role = role;
    }

    public UserRoleDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole { id=" + id + ", role=" + role + " }";
    }
}
