package com.quayal.spring5recipeapp.services;

import com.quayal.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {


    Set<Recipe> getRecipes();
}
