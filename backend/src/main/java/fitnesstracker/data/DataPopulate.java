package fitnesstracker.data;

import fitnesstracker.entities.exercise.DistanceCardioExercise;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.IsometricExercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.entities.person.Person;
import fitnesstracker.services.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Component
public class DataPopulate {

    private final MealService mealService;
    private final IngredientService ingredientService;
    private final HealthStatisticService healthStatisticService;
    private final PersonService personService;
    private final ExerciseHistoryService exerciseHistoryService;

    @Autowired
    public DataPopulate(MealService mealService, IngredientService ingredientService, HealthStatisticService healthStatisticService, ExerciseHistoryService exerciseHistoryService, PersonService personService) {
        this.mealService = mealService;
        this.ingredientService = ingredientService;
        this.healthStatisticService = healthStatisticService;
        this.exerciseHistoryService = exerciseHistoryService;
        this.personService = personService;
    }

    public void populateData() {
        //*******************************************************************************
        Person person1 = new Person(1L, "Bob", "Tables", "bob123", "password1");
        personService.savePerson(person1);
        Person person2 = new Person(2L, "Tom", "Rands", "tom123", "password2");
        personService.savePerson(person2);
        //*******************************************************************************

        //*******************************************************************************
        String[] meal1IngredientNames = {"chicken", "Vegetables", "Soy Sauce"};

        String imagePath1 = "src/main/resources/chicken-stir-fry-1.jpg";
        byte[] imageData1 = readImageDataFromFile(imagePath1);

        Meal chickenStirFry = new Meal(
                null,
                "Chicken Stir Fry",
                "Lunch",
                500,
                "Stir-fry chicken with vegetables and soy sauce",
                person1.getId(),
                imageData1
        );
        saveMeal(meal1IngredientNames, chickenStirFry);
        //*******************************************************************************

        //*******************************************************************************
        String[] meal2IngredientNames = {"Salmon", "Fresh Salad"};

        String imagePath2 = "src/main/resources/super-food-salmon-salad-hero.jpg";
        byte[] imageData2 = readImageDataFromFile(imagePath2);

        Meal salmonSalad = new Meal(
                null,
                "Salmon Salad",
                "Dinner",
                400,
                "Grilled salmon served with a fresh salad",
                person1.getId(),
                imageData2
        );
        saveMeal(meal2IngredientNames, salmonSalad);
        //*******************************************************************************

        //*******************************************************************************
        String[] meal3IngredientNames = {"Pasta", "Tomato Sauce", "Vegetables", "Cheese"};

        String imagePath3 = "src/main/resources/Spaghetti-with-Baked-Brie-Mushrooms-Spinach-dca7ad0b8a8f4156b78baf9debc988b3.jpg";
        byte[] imageData3 = readImageDataFromFile(imagePath3);

        Meal vegetarianPasta = new Meal(
                null,
                "Vegetarian Pasta",
                "Dinner",
                600,
                "Pasta with tomato sauce, vegetables, and cheese",
                person1.getId(),
                imageData3
            );
        saveMeal(meal3IngredientNames, vegetarianPasta);
        //*******************************************************************************

        //*******************************************************************************
        Exercise exercise1 = new WeightLiftingExercise(person1.getId(), "Barbell rows", LocalDateTime.of(2023, 11, 30, 10, 0), LocalDateTime.of(2023, 11, 30, 11, 0), 250, 5, 5,12);
        exercise1.setEquipmentRequired("Barbell and free weights");
        exercise1.setDescription("Just do whatever man");
        exerciseHistoryService.addExercise(exercise1);

        Exercise exercise2 = new WeightLiftingExercise(person1.getId(), "Deadlifts", LocalDateTime.of(2023, 11, 30, 10, 0), LocalDateTime.of(2023, 11, 30, 11, 0), 250, 5, 5,50);
        exercise2.setEquipmentRequired("Barbell and free weights");
        exercise2.setDescription("Just don't pop your shoulder");
        exerciseHistoryService.addExercise(exercise2);

        Exercise exercise3 = new WeightLiftingExercise(person1.getId(), "Deadlifts", LocalDateTime.of(2023, 11, 30, 12, 0), LocalDateTime.of(2023, 11, 30, 14, 0), 200, 3, 12, 100);
        exerciseHistoryService.addExercise(exercise3);

        Exercise exercise4 = new DistanceCardioExercise(person1.getId(), "Running", LocalDateTime.of(2023, 12, 1, 8, 0), LocalDateTime.of(2023, 12, 1, 9, 0), 300, 10.5);
        exercise4.setDescription("Morning run in the park");
        exerciseHistoryService.addExercise(exercise4);


        Exercise exercise5 = new IsometricExercise(person1.getId(), "Plank", LocalDateTime.of(2023, 12, 2, 15, 0), LocalDateTime.of(2023, 12, 2, 15, 5), 50,"Core");
        exercise5.setDescription("Hold a plank position for 5 minutes");
        exerciseHistoryService.addExercise(exercise5);

        // Weight Lifting Exercises
        Exercise exercise6 = new WeightLiftingExercise(person1.getId(), "Bench Press", LocalDateTime.of(2023, 12, 5, 12, 0), LocalDateTime.of(2023, 12, 5, 13, 0), 180, 4, 8, 150);
        exercise6.setEquipmentRequired("Barbell and bench");
        exercise6.setDescription("Focus on proper form and controlled movements");
        exerciseHistoryService.addExercise(exercise6);

        Exercise exercise7 = new WeightLiftingExercise(person2.getId(), "Dumbbell Lunges", LocalDateTime.of(2023, 12, 8, 9, 0), LocalDateTime.of(2023, 12, 8, 10, 0), 120, 3, 12, 40);
        exercise7.setEquipmentRequired("Dumbbells");
        exercise7.setDescription("Strengthen your legs and improve balance");
        exerciseHistoryService.addExercise(exercise7);

        Exercise exercise8 = new DistanceCardioExercise(person2.getId(), "Cycling", LocalDateTime.of(2023, 12, 10, 18, 0), LocalDateTime.of(2023, 12, 10, 19, 0), 400, 20.5);
        exercise8.setDescription("Evening bike ride around the neighborhood");
        exerciseHistoryService.addExercise(exercise8);

        Exercise exercise9 = new DistanceCardioExercise(person2.getId(), "Swimming", LocalDateTime.of(2023, 12, 15, 7, 0), LocalDateTime.of(2023, 12, 15, 8, 0), 350, 1.5);
        exercise9.setDescription("Lap swimming for cardiovascular fitness");
        exerciseHistoryService.addExercise(exercise9);

        Exercise exercise10 = new IsometricExercise(person2.getId(), "Wall Sit", LocalDateTime.of(2023, 12, 18, 14, 0), LocalDateTime.of(2023, 12, 18, 14, 5), 60, "Legs");
        exercise10.setDescription("Hold a wall sit position for one minute");
        exerciseHistoryService.addExercise(exercise10);

        Exercise exercise11 = new IsometricExercise(person2.getId(), "Plank with Shoulder Taps", LocalDateTime.of(2023, 12, 20, 16, 0), LocalDateTime.of(2023, 12, 20, 16, 5), 70, "Core");
        exercise11.setDescription("Plank with alternating shoulder taps for added challenge");
        exerciseHistoryService.addExercise(exercise11);

        //*******************************************************************************

        HealthStatistic healthStatistic1 = new HealthStatistic(null, 23.0, 60.0, 80.0, 90.0, 0, 0, 65.0, 10.0, person1.getId());
        healthStatisticService.createHealthStatistic(healthStatistic1);
        HealthStatistic healthStatistic2 = new HealthStatistic(null, 24.0, 61.0, 81.0, 91.0, 0, 0, 66.0, 11.0, person2.getId());
        healthStatisticService.createHealthStatistic(healthStatistic2);
        HealthStatistic healthStatistic3 = new HealthStatistic(null, 24.0, 61.0, 81.0, 91.0, 0, 0, 66.0, 11.0, person1.getId());
        healthStatisticService.createHealthStatistic(healthStatistic3);
        HealthStatistic healthStatistic4 = new HealthStatistic(null, 24.0, 61.0, 81.0, 91.0, 0, 0, 66.0, 11.0, person2.getId());
        healthStatisticService.createHealthStatistic(healthStatistic4);

    }
    private void saveMeal(String @NotNull [] mealIngredientNames, Meal meal) {
        for (String ingredientName : mealIngredientNames) {
            if (ingredientService.getIngredientByIngredientName(ingredientName) == null) {
                Ingredient ingredient = new Ingredient(ingredientName);
                ingredientService.saveIngredient(ingredient);
            }
        }

        for (String ingredientName : mealIngredientNames) {
            Ingredient ingredient = ingredientService.getIngredientByIngredientName(ingredientName);
            meal.addIngredient(ingredient);
            ingredient.addMeal(meal);
            ingredientService.saveIngredient(ingredient);
        }

        mealService.saveMeal(meal);
    }

    private byte @Nullable [] readImageDataFromFile(String imagePath) {
        try {
            Path path = Paths.get(imagePath);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
