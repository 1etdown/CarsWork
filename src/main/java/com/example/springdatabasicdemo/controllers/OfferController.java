package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.springdatabasicdemo.repositories.UserRepository;

import jakarta.validation.Valid;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private final OfferService offerService;
    @Autowired
    private final ModelService modelService;
    @Autowired
    private final BrandService brandService;
    private final UserRepository userRepository;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    private final OfferRepository offerRepository;



    @Autowired
    public OfferController(OfferRepository offerRepository,OfferService offerService, ModelService modelService, BrandService brandService, UserRepository userRepository) {
        this.offerService = offerService;
        this.modelService= modelService;
        this.brandService=brandService;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }
    @GetMapping("/add")
    public String addOffer(Model model) {

        model.addAttribute("availableModels", modelService.getAll());
        return "offer-add";
    }

    @ModelAttribute("offerModel")
    public AddOfferDto initOffer() {
        return new AddOfferDto();
    }
    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDto offerModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Authentication authentication, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/add";
        }

        String username = principal.getName();
        offerModel.setUser(username);
        offerModel.setCreated(new Date());
        offerModel.setModified(new Date());

        offerService.createOffer(offerModel);
        return "redirect:/offers/all";
    }


    @GetMapping("/all")
    public String showAllOffers(
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            @RequestParam(name = "sort", defaultValue = "asc") String sort,
            Principal principal,
            Model model) {
        LOG.log(Level.INFO, "Show All offers for " + principal.getName());

        List<ShowOfferDto> showofferDtos;

        if (minPrice != null && maxPrice != null) {
            showofferDtos = offerService.getByPriceRange(minPrice, maxPrice);
        } else {
            showofferDtos = offerService.getAll();
        }



        model.addAttribute("showofferDtos", showofferDtos);
        return "offer-all";
    }



    @GetMapping("/offer-details/{offer-id}")
    public String OfferDetails(@PathVariable("offer-id") UUID id, Model model) {
        model.addAttribute("offerDetails", offerService.offerDetails(id));
        return "offer-details";
    }


    @GetMapping("/offer-delete/{id}")
    public String deleteOffer(@PathVariable UUID id) {
        offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

    @GetMapping("/offer-edit/{id}")
    public String editOffer(@PathVariable UUID id, Model model) {
        OfferDto offer = offerService.find(id).orElse(null);
        model.addAttribute("offerModel", offer);
        return "offer-edit";
    }

    @PostMapping("/offer-edit")
    public String editOffer(@Valid @ModelAttribute("offerModel") OfferDto offerModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/offer-edit/" + offerModel.getId();
        }

        offerService.updateOffer(offerModel);
        return "redirect:/offers/all";
    }

   /* public List<ShowOfferDto> getLastTwoOffers() {
        List<ShowOfferDto> allOffersSortedByDate = offerRepository.getAllOffersSortedByDate();


        int size = allOffersSortedByDate.size();
        int startIndex = size - 2 >= 0 ? size - 2 : 0;
        int endIndex = size;

        return allOffersSortedByDate.subList(startIndex, endIndex);
    }*/
}
