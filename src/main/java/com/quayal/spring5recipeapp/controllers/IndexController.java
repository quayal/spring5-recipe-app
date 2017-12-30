package com.quayal.spring5recipeapp.controllers;

import com.quayal.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;


    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "", "/index"})
    public String getIndexPage(Model model) {

        log.debug("Index page loaded");

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
