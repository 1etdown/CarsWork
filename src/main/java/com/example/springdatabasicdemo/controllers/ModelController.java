package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.services.ModelService;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/models")
public class ModelController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/add")
    public String addModel(Model model) {
        return "model-add";
    }

    @ModelAttribute("modelModel")
    public AddModelDto initModel() {
        return new AddModelDto();
    }


    @PostMapping("/add")
    public String addModel(@Valid  AddModelDto modelModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelModel", modelModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelDto",
                    bindingResult);
            return "redirect:/models/add";
        }

        modelService.createModel(modelModel);
        return "redirect:/models/all";
    }

    @GetMapping("/all")
    public String showAllModels(Principal principal, Model model) {
        LOG.log(Level.INFO, "Show All Models for" + principal.getName());
        List<ShowModelDto> showmodelDtos = modelService.getAll();
        model.addAttribute("showmodelDtos", showmodelDtos);
        return "model-all";
    }

    @GetMapping("/model-delete/{id}")
    public String deleteModel(@PathVariable UUID id) {
        modelService.deleteModel(id);
        return "redirect:/models/all";
    }

    @GetMapping("/model-edit/{id}")
    public String editModel(@PathVariable UUID id, Model model) {
        ModelDto modelDto = modelService.find(id).orElse(null);
        model.addAttribute("modelDto", modelDto);
        return "model-edit";
    }

    @PostMapping("/model-edit")
    public String editModel(@Valid @ModelAttribute("modelDto") ModelDto modelDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelDto", modelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelDto",
                    bindingResult);
            return "redirect:/models/model-edit/" + modelDto.getId();
        }
        modelService.updateModel(modelDto);
        return "redirect:/models/all";
    }
}
