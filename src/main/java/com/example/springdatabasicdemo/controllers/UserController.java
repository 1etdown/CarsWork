package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("userModel", new UserDto());
        model.addAttribute("availableUsers", userService.getAll()); // Provide the list of users
        return "user-add";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("userModel") UserDto user,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userModel", user);
            model.addAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/add";
        }

        userService.createUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<UserDto> userDtos = userService.getAll();
        model.addAttribute("userDtos", userDtos);
        return "user-all";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return "redirect:/users/all";
    }

    @GetMapping("/user-edit/{id}")
    public String editUser(@PathVariable UUID id, Model model) {
        UserDto user = userService.find(id).orElse(null);
        model.addAttribute("userModel", user);
        return "user-edit";
    }

    @PostMapping("/user-edit")
    public String editUser(@Valid @ModelAttribute("userModel") UserDto user,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userModel", user);
            model.addAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/user-edit/" + user.getId();
        }

        userService.updateUser(user);
        return "redirect:/users/all";
    }

}
