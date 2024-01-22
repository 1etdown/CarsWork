package com.example.springdatabasicdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.services.*;

import java.util.List;

@Controller
public class HomeController {
    private final OfferService offerService;
    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/")
    public String homePage(Model model) {
        List<ShowOfferDto> lastTwoOffers = offerService.getTwoOffers();
        model.addAttribute("lastTwoOffers", lastTwoOffers);
        return "index";
    }
}