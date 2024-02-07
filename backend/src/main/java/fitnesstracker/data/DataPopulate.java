package fitnesstracker.data;

import fitnesstracker.entities.exercise.*;
import fitnesstracker.entities.person.Person;
import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
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
import java.util.Arrays;
import java.util.Random;

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
        Person person1 = new Person("Bobby", "Donald", "bob123@fitsync.com", "password1");
        personService.savePerson(person1);
        Person person2 = new Person("Billy", "Bolt", "bill123fitsync.com", "password2");
        personService.savePerson(person2);
        Person person3 = new Person("Alice", "Anderson", "alice123@fitsync.com", "password3");
        personService.savePerson(person3);
        Person person4 = new Person("Charlie", "Chaplin", "charlie123@fitsync.com", "password4");
        personService.savePerson(person4);
        Person person5 = new Person("Diana", "Doe", "diana123@fitsync.com", "password5");
        personService.savePerson(person5);
        Person person6 = new Person("Eva", "Evans", "eva123@fitsync.com", "password6");
        personService.savePerson(person6);
        Person person7 = new Person("Frank", "Fisher", "frank123@fitsync.com", "password7");
        personService.savePerson(person7);
        Person person8 = new Person("Grace", "Gibson", "grace123@fitsync.com", "password8");
        personService.savePerson(person8);
        Person person9 = new Person("Harry", "Harrison", "harry123@fitsync.com", "password9");
        personService.savePerson(person9);
        Person person10 = new Person("Ivy", "Irwin", "ivy123@fitsync.com", "password10");
        personService.savePerson(person10);
        Person person11 = new Person("Test", "user", "1", "1");
        personService.savePerson(person11);
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
        Exercise exercise1 = new WeightLiftingExercise(person1.getId(), "Barbell rows", LocalDateTime.of(2023, 11, 30, 10, 0), LocalDateTime.of(2023, 11, 30, 11, 0), 250, 5, 5, 12, "Back");
        exercise1.setEquipmentRequired("Barbell and free weights");
        exercise1.setDescription("Just do whatever man");
        exerciseHistoryService.addExercise(exercise1);

        Exercise exercise2 = new WeightLiftingExercise(person1.getId(), "Deadlifts", LocalDateTime.of(2023, 11, 30, 10, 0), LocalDateTime.of(2023, 11, 30, 11, 0), 250, 5, 5, 50, "Legs");
        exercise2.setEquipmentRequired("Barbell and free weights");
        exercise2.setDescription("Just don't pop your shoulder");
        exerciseHistoryService.addExercise(exercise2);

        Exercise exercise3 = new WeightLiftingExercise(person1.getId(), "Deadlifts", LocalDateTime.of(2023, 11, 30, 12, 0), LocalDateTime.of(2023, 11, 30, 14, 0), 200, 3, 12, 100, "Legs");
        exerciseHistoryService.addExercise(exercise3);

        Exercise exercise4 = new DistanceCardioExercise(person1.getId(), "Running", LocalDateTime.of(2023, 12, 1, 8, 0), LocalDateTime.of(2023, 12, 1, 9, 0), 300, 10.5);
        exercise4.setDescription("Morning run in the park");
        exerciseHistoryService.addExercise(exercise4);


        Exercise exercise5 = new IsometricExercise(person1.getId(), "Plank", LocalDateTime.of(2023, 12, 2, 15, 0), LocalDateTime.of(2023, 12, 2, 15, 5), 50, "Core");
        exercise5.setDescription("Hold a plank position for 5 minutes");
        exerciseHistoryService.addExercise(exercise5);

        Exercise exercise6 = new WeightLiftingExercise(person1.getId(), "Bench Press", LocalDateTime.of(2023, 12, 5, 12, 0), LocalDateTime.of(2023, 12, 5, 13, 0), 180, 4, 8, 150, "Chest");
        exercise6.setEquipmentRequired("Barbell and bench");
        exercise6.setDescription("Focus on proper form and controlled movements");
        exerciseHistoryService.addExercise(exercise6);

        Exercise exercise7 = new WeightLiftingExercise(person2.getId(), "Dumbbell Lunges", LocalDateTime.of(2023, 12, 8, 9, 0), LocalDateTime.of(2023, 12, 8, 10, 0), 120, 3, 12, 40, "Legs");
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

        Exercise exercise12 = new BodyweightExercise(person2.getId(), "Push-ups", LocalDateTime.of(2023, 12, 18, 14, 0), LocalDateTime.of(2023, 12, 18, 14, 5), 150, 3, 10, "Chest");
        exercise12.setDescription("Just do it");
        exerciseHistoryService.addExercise(exercise12);

        Exercise exercise13 = new NoDistanceCardioExercise(person2.getId(), "Burpees", LocalDateTime.of(2023, 12, 18, 14, 0), LocalDateTime.of(2023, 12, 18, 14, 5), 100);
        exercise13.setDescription("Let's see your cardio skills");
        exerciseHistoryService.addExercise(exercise13);

        Exercise exercise16 = new BodyweightExercise(person2.getId(), "Squats", LocalDateTime.of(2023, 12, 21, 15, 0), LocalDateTime.of(2023, 12, 21, 15, 15), 100, 3, 15, "Legs");
        exercise16.setDescription("Keep your knees aligned and go as low as you can comfortably");
        exerciseHistoryService.addExercise(exercise16);

        Exercise exercise17 = new NoDistanceCardioExercise(person2.getId(), "Jumping Jacks", LocalDateTime.of(2023, 12, 22, 9, 0), LocalDateTime.of(2023, 12, 22, 9, 10), 200);
        exercise17.setDescription("A classic cardio exercise to get your heart pumping");
        exerciseHistoryService.addExercise(exercise17);

        //*******************************************************************************
        for (Person person : Arrays.asList(person1, person2, person3, person4, person5)) {
            for (int i = 0; i < 50; i++) {
                int randomWeight = getRandomIntInRange(20, 30);
                int randomBloodPressure = getRandomIntInRange(60, 90);
                int randomHydration = getRandomIntInRange(70, 100);
                int randomCalorieIn = getRandomIntInRange(1500, 3000);
                int randomCalorieOut = getRandomIntInRange(1000, 2500);
                int randomHeartRate = getRandomIntInRange(60, 100);
                int randomStress = getRandomIntInRange(0, 20);

                HealthStatistic healthStatistic = new HealthStatistic(
                        null,
                        randomWeight,
                        randomBloodPressure,
                        randomHydration,
                        randomCalorieIn,
                        0,
                        0,
                        randomHeartRate,
                        randomStress,
                        person.getId()
                );

                healthStatisticService.createHealthStatistic(healthStatistic);
            }
        }
    }
    //*******************************************************************************************
    // Helper method to get a random integer in a specified range
    private int getRandomIntInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    private static double getRandomDoubleInRange ( double min, double max){
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
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
