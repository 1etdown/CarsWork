package com.example.springdatabasicdemo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.repositories.*;

import com.example.springdatabasicdemo.services.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/")

    public String homePage() {
        return "index";
    }
}