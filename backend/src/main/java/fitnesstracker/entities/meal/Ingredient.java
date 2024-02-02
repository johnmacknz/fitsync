package fitnesstracker.entities.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Schema(description = "Ingredient Information")
public class Ingredient {

    public Ingredient() {
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Ingredient ID", example = "1")
    Long id;
    public Long getId() {
        return id;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.EAGER)
    Set<Meal> meals = new HashSet<>();

    public Set<Meal> getMeals() {
        return meals;
    }
    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    @Schema(description = "Name of the Ingredient", example = "Banana")
    String ingredientName;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
