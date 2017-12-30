package com.quayal.spring5recipeapp.bootstrap;

import com.quayal.spring5recipeapp.domain.*;
import com.quayal.spring5recipeapp.repositories.CategoryRepository;
import com.quayal.spring5recipeapp.repositories.RecipeRepository;
import com.quayal.spring5recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
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
        log.debug("Loading Bootstrap Data");
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

        Optional<UnitOfMeasure> poundUomOptional = unitOfMeasureRepository.findByDescription("Pound");
        if (!poundUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }

        UnitOfMeasure pcsUom = pcsUomOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure poundUom = poundUomOptional.get();

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

        perfectGuacamole.addIngredient(new Ingredient("Ripe avocados", new BigDecimal(2.00), pcsUom));
        perfectGuacamole.addIngredient(new Ingredient("Kosher salt", new BigDecimal(0.5), teaspoonUom));
        perfectGuacamole.addIngredient(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(1), tablespoonUom));
        perfectGuacamole.addIngredient(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom));
        perfectGuacamole.addIngredient(new Ingredient("Cilantro (leaves and tender stems", new BigDecimal(2), tablespoonUom));
        perfectGuacamole.addIngredient(new Ingredient("Serrano chili", new BigDecimal(2), pcsUom));
        perfectGuacamole.addIngredient(new Ingredient("Freshly grated black pepper", new BigDecimal(1), dashUom));
        perfectGuacamole.addIngredient(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), pcsUom));

        recipes.add(perfectGuacamole);

        log.debug("Perfect Guacamole recipe added");

        Recipe chickenTacos = new Recipe();

        chickenTacos.setPrepTime(20);
        chickenTacos.setCookTime(15);
        chickenTacos.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes." +
                " Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        Notes chickenNotes = new Notes();
        chickenNotes.setRecipeNotes("Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them."+
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day?" +
                        "Now that’s living!\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz52dlsgJfj");
        chickenTacos.setNotes(chickenNotes);
        chickenTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin," +
                " sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste." +
                " Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, " +
                "or until a thermometer inserted into the thickest part of the meat registers 165F. " +
                "Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat." +
                " As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs" +
                " and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small" +
                " handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices." +
                " Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz52dmLKNkB");

        chickenTacos.getCategories().add(mexicanCategory);
        chickenTacos.getCategories().add(americanCategory);

        chickenTacos.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), tablespoonUom));
        chickenTacos.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), teaspoonUom));
        chickenTacos.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), teaspoonUom));
        chickenTacos.addIngredient(new Ingredient("sugar", new BigDecimal(1), teaspoonUom));
        chickenTacos.addIngredient(new Ingredient("salt", new BigDecimal(.5), teaspoonUom));
        chickenTacos.addIngredient(new Ingredient("clove garlic, finely chopped", new BigDecimal(1), pcsUom));
        chickenTacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tablespoonUom));
        chickenTacos.addIngredient(new Ingredient("freshly squeezed orange juice", new BigDecimal(3), tablespoonUom));
        chickenTacos.addIngredient(new Ingredient("olive oil", new BigDecimal(2), tablespoonUom));
        chickenTacos.addIngredient(new Ingredient("skinless, boneless chicken thighs", new BigDecimal(1.25), poundUom));
        chickenTacos.addIngredient(new Ingredient("small corn tortilla", new BigDecimal(8), pcsUom));
        chickenTacos.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupUom));
        chickenTacos.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), pcsUom));
        chickenTacos.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), pcsUom));
        chickenTacos.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(.5), pintUom));
        chickenTacos.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(.25), pcsUom));
        chickenTacos.addIngredient(new Ingredient("roughly chopped cilantro", new BigDecimal(1), cupUom));
        chickenTacos.addIngredient(new Ingredient("sour cream thinned with 1/4 cup milk", new BigDecimal(0.5), cupUom));
        chickenTacos.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(1), pcsUom));

        recipes.add(chickenTacos);

        log.debug("Chicken Tacos recipe added");
        return recipes;
    }
}

