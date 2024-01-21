package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/userRoles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {this.userRoleService = userRoleService;
    }
    @PostMapping
    public UserRoleDto createUserRole(@RequestBody UserRoleDto userRole) {return userRoleService.createUserRole(userRole);
    }
    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable UUID id) {userRoleService.deleteUserRole(id);
    }
    @GetMapping
    public List<UserRoleDto> getAllUserRoles() {return userRoleService.getAll();
    }

    @GetMapping("/{id}")
    public UserRoleDto getUserRole(@PathVariable UUID id) {return userRoleService.find(id).orElse(null);
    }

    @PutMapping
    public UserRoleDto updateUserRole(@RequestBody UserRoleDto userRole) {return userRoleService.updateUserRole(userRole);
    }


}
