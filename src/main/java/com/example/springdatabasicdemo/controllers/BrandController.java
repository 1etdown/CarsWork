package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.services.BrandService;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import jakarta.validation.Valid;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.Date;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    @Autowired
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public String addBrand() {
        return "brand-add";
    }
    @ModelAttribute ("brandModel")
    public AddBrandDto initBrand(){return new AddBrandDto();}
    @PostMapping("/add")
    public String addBrand(@Valid AddBrandDto brandModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/add";

        }
        brandModel.setCreated(new Date());
        brandModel.setModified(new Date());

        brandService.createBrand(brandModel);
        return "index";
    }

    @GetMapping("/all")
    public String showAllBrands(Principal principal, Model model) {
        LOG.log(Level.INFO, "Show All Brands for" + principal.getName());
        List<ShowBrandDto> showbrandDtos = brandService.getAll();
        model.addAttribute("brandDtos", showbrandDtos);
        return "brand-all";
    }



    @GetMapping("/brand-delete/{id}")
    public String deleteBrand(@PathVariable UUID id) {
        brandService.deleteBrand(id);
        return "redirect:/brands/all";
    }

    @GetMapping("/brand-edit/{id}")
    public String editBrand(@PathVariable UUID id, Model model) {
        ShowBrandDto brand = brandService.find(id).orElse(null);
        model.addAttribute("brandModel", brand);
        return "brand-edit";
    }

    @PostMapping("/brand-edit")
    public String editBrand(@Valid @ModelAttribute("brandModel") BrandDto brandModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/brand-edit/" + brandModel.getId();
        }
        brandService.updateBrand(brandModel);
        return "redirect:/brands/all";

    }

}
