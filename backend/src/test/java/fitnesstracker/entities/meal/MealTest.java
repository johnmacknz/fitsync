package fitnesstracker.entities.meal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import fitnesstracker.entities.Person;
import org.junit.jupiter.api.Test;

class MealTest {

    @Test
    void testConstructor() {
        Meal actualMeal = new Meal();
        actualMeal.setCalories(1);
        actualMeal.setCookingInstructions("Cooking Instructions");
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        actualMeal.setIngredients((Set<Ingredient>) ingredientList);
        actualMeal.setMealName("Meal Name");
        actualMeal.setMealType("Meal Type");

        assertEquals(1, actualMeal.getCalories().intValue());
        assertEquals("Cooking Instructions", actualMeal.getCookingInstructions());
        assertNull(actualMeal.getId());
        assertSame(ingredientList, actualMeal.getIngredients());
        assertEquals("Meal Name", actualMeal.getMealName());
        assertEquals("Meal Type", actualMeal.getMealType());
    }

    @Test
    void testConstructor2() {
        LocalDate date = null;
        Person person1 = new Person(1L, "Bob", "bob123", "password1");
        ArrayList<Ingredient> ingredientList = new ArrayList<>();

//        Meal actualMeal = new Meal(date,"Meal Name", "Meal Type", 1, "Cooking Instructions", ingredientList, person1.getId());
//        actualMeal.setCalories(1);
//        actualMeal.setCookingInstructions("Cooking Instructions");
//        ArrayList<Ingredient> ingredientList1 = new ArrayList<>();
//        actualMeal.setIngredients((Set<Ingredient>) ingredientList1);
//        actualMeal.setMealName("Meal Name");
//        actualMeal.setMealType("Meal Type");

//        assertEquals(1, actualMeal.getCalories().intValue());
//        assertEquals("Cooking Instructions", actualMeal.getCookingInstructions());
//        assertNull(actualMeal.getId());
//        List<Ingredient> ingredientList2 = (List<Ingredient>) actualMeal.getIngredients();
//        assertSame(ingredientList1, ingredientList2);
//        assertEquals(ingredientList, ingredientList2);
//        assertEquals("Meal Name", actualMeal.getMealName());
//        assertEquals("Meal Type", actualMeal.getMealType());
    }
}

