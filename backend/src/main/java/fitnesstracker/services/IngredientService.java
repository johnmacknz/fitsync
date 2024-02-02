package fitnesstracker.services;

import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.exceptions.IngredientServiceException;
import fitnesstracker.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class IngredientService {
    
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    
    IngredientRepository ingredientRepository;
    
    public boolean repoIsEmpty() {
        return ingredientRepository.findAll().isEmpty();
    }
    
    public List<Ingredient> findAll() {
        try {
            return this.ingredientRepository.findAll();
        } catch (Exception e) {
            throw new IngredientServiceException("An error occurred while fetching ingredients", e);
        }
    }

    public Ingredient getIngredientById(long ingredientId) {
        Optional<Ingredient> ingredient = this.ingredientRepository.findById(ingredientId);
        return ingredient.orElse(null);
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        return this.ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientByIngredientName(String ingredientName) {
        Optional<Ingredient> ingredient = this.ingredientRepository.findByIngredientName(ingredientName);
        return ingredient.orElse(null);
    }
}
