package fitnesstracker.services;

import fitnesstracker.entities.meal.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IngredientServiceTest {

    @Autowired
    IngredientService ingredientService;

    @Test
    void saveIngredient() {
    }

    @Test
    void getIngredientByIngredientName() {
        Ingredient ingredient = new Ingredient("Tofu");
        ingredientService.saveIngredient(ingredient);


    }
}