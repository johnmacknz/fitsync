package fitnesstracker.repositories;

import fitnesstracker.entities.meal.Ingredient;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends ListCrudRepository<Ingredient, Long> {
    Optional<Ingredient> findByIngredientName(String ingredientName);
}

