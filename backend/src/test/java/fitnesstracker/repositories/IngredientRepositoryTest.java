package fitnesstracker.repositories;

import fitnesstracker.entities.meal.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @Test
    void findByIngredientName() {
        Ingredient ingredient = new Ingredient("Tofu");
        ingredientRepository.save(ingredient);

        Optional<Ingredient> ingredient1 = ingredientRepository.findByIngredientName("Tofu");

        assertTrue(ingredient1.isPresent());
    }
}