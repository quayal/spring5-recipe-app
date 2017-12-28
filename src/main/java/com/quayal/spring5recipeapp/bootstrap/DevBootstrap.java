package com.quayal.spring5recipeapp.bootstrap;

import com.quayal.spring5recipeapp.domain.*;
import com.quayal.spring5recipeapp.repositories.CategoryRepository;
import com.quayal.spring5recipeapp.repositories.RecipeRepository;
import com.quayal.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    public List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>();
        Optional<UnitOfMeasure> pcsUomOptional = unitOfMeasureRepository.findByDescription("Pcs");
        if (!pcsUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tablespoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaspoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        UnitOfMeasure pcsUom = pcsUomOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();

        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> americanOptional = categoryRepository.findByDescription("American");

        if (!americanOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Category mexicanCategory = mexicanOptional.get();

        Category americanCategory = americanOptional.get();

        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.setDescription("Guacamole, a dip made from avocados, " +
                "is originally from Mexico. The name is derived from two Aztec Nahuatl" +
                " words—ahuacatl (avocado) and molli (sauce).");
        perfectGuacamole.setCookTime(0);
        perfectGuacamole.setPrepTime(10);
        perfectGuacamole.setDifficulty(Difficulty.EASY);
        perfectGuacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. " +
                "Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. " +
                "(See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. " +
                "(Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. " +
                "The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados" +
                " from turning brown." +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness." +
                " So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. " +
                "Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it " +
                "and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) " +
                "Refrigerate until ready to serve." +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");

        perfectGuacamole.setNotes(guacNotes);

        perfectGuacamole.getCategories().add(mexicanCategory);
        perfectGuacamole.getCategories().add(americanCategory);

        perfectGuacamole.getIngredients().add(new Ingredient("Ripe avocados", new BigDecimal(2.00), pcsUom, perfectGuacamole));
        perfectGuacamole.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.5), teaspoonUom, perfectGuacamole));
        perfectGuacamole.getIngredients().add(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(1), tablespoonUom, perfectGuacamole));
        perfectGuacamole.getIngredients().add(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom, perfectGuacamole));
        perfectGuacamole.getIngredients().add(new Ingredient("Cilantro (leaves and tender stems", new BigDecimal(2), tablespoonUom, perfectGuacamole));
        perfectGuacamole.getIngredients().add(new Ingredient("Serrano chili", new BigDecimal(2), pcsUom, perfectGuacamole));
        perfectGuacamole.getIngredients().add(new Ingredient("Freshly grated black pepper", new BigDecimal(1), dashUom, perfectGuacamole));
        perfectGuacamole.getIngredients().add(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), pcsUom, perfectGuacamole));

        recipes.add(perfectGuacamole);

        return recipes;
    }
}

