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

       //Person1 exercises
        Exercise exercise1Person1 = new WeightLiftingExercise(person1.getId(), "Squats", LocalDateTime.of(2023, 12, 1, 10, 0), LocalDateTime.of(2023, 12, 1, 10, 30), 200, 3, 10, 30, "Legs");
        exercise1Person1.setEquipmentRequired("Barbell and free weights");
        exercise1Person1.setDescription("Maintain proper form throughout");
        exerciseHistoryService.addExercise(exercise1Person1);

        Exercise exercise2Person1 = new DistanceCardioExercise(person1.getId(), "Running", LocalDateTime.of(2023, 12, 2, 8, 0), LocalDateTime.of(2023, 12, 2, 8, 45), 400, 12.5);
        exercise2Person1.setDescription("Scenic route through the park");
        exerciseHistoryService.addExercise(exercise2Person1);

        Exercise exercise3Person1 = new IsometricExercise(person1.getId(), "Plank", LocalDateTime.of(2023, 12, 3, 15, 0), LocalDateTime.of(2023, 12, 3, 15, 5), 60, "Core");
        exercise3Person1.setDescription("Challenge yourself, hold it for a minute");
        exerciseHistoryService.addExercise(exercise3Person1);

        Exercise exercise4Person1 = new NoDistanceCardioExercise(person1.getId(), "Jumping Jacks", LocalDateTime.of(2023, 12, 4, 9, 0), LocalDateTime.of(2023, 12, 4, 9, 10), 250);
        exercise4Person1.setDescription("Elevate your heart rate");
        exerciseHistoryService.addExercise(exercise4Person1);

        Exercise exercise5Person1 = new BodyweightExercise(person2.getId(), "Push-ups", LocalDateTime.of(2023, 12, 18, 14, 0), LocalDateTime.of(2023, 12, 18, 14, 5), 150, 3, 10, "Chest");
        exercise5Person1.setDescription("Focus on controlled movements");
        exerciseHistoryService.addExercise(exercise5Person1);

        Exercise exercise6Person1 = new WeightLiftingExercise(person1.getId(), "Bench Press", LocalDateTime.of(2023, 12, 6, 9, 30), LocalDateTime.of(2023, 12, 6, 10, 15), 180, 4, 8, 30, "Chest");
        exercise6Person1.setEquipmentRequired("Barbell and bench");
        exercise6Person1.setDescription("Use a spotter for heavy lifts");
        exerciseHistoryService.addExercise(exercise6Person1);

        Exercise exercise7Person1 = new DistanceCardioExercise(person1.getId(), "Cycling", LocalDateTime.of(2023, 12, 7, 16, 0), LocalDateTime.of(2023, 12, 7, 17, 0), 500, 25.0);
        exercise7Person1.setDescription("Explore different bike trails");
        exerciseHistoryService.addExercise(exercise7Person1);

        Exercise exercise8Person1 = new IsometricExercise(person1.getId(), "Side Plank", LocalDateTime.of(2023, 12, 8, 14, 0), LocalDateTime.of(2023, 12, 8, 14, 3), 45, "Core");
        exercise8Person1.setDescription("Engage your core and maintain a straight line");
        exerciseHistoryService.addExercise(exercise8Person1);

        Exercise exercise9Person1 = new BodyweightExercise(person1.getId(), "Lunges", LocalDateTime.of(2023, 12, 9, 11, 0), LocalDateTime.of(2023, 12, 9, 11, 15), 0, 3, 12, "Legs");
        exercise9Person1.setDescription("Focus on balance and controlled movements");
        exerciseHistoryService.addExercise(exercise9Person1);

        Exercise exercise10Person1 = new NoDistanceCardioExercise(person1.getId(), "High Knees", LocalDateTime.of(2023, 12, 10, 10, 0), LocalDateTime.of(2023, 12, 10, 10, 10), 150);
        exercise10Person1.setDescription("Elevate your heart rate with high-intensity cardio");
        exerciseHistoryService.addExercise(exercise10Person1);

        //Person2 exercises
        Exercise exercise1Person2 = new WeightLiftingExercise(person2.getId(), "Deadlifts", LocalDateTime.of(2023, 12, 11, 12, 0), LocalDateTime.of(2023, 12, 11, 13, 0), 250, 5, 5, 50, "Legs");
        exercise1Person2.setEquipmentRequired("Barbell and free weights");
        exercise1Person2.setDescription("Focus on proper hip hinge movement");
        exerciseHistoryService.addExercise(exercise1Person2);

        Exercise exercise2Person2 = new DistanceCardioExercise(person2.getId(), "Running", LocalDateTime.of(2023, 12, 12, 8, 0), LocalDateTime.of(2023, 12, 12, 8, 45), 300, 10.5);
        exercise2Person2.setDescription("Morning run around the block");
        exerciseHistoryService.addExercise(exercise2Person2);

        Exercise exercise3Person2 = new IsometricExercise(person2.getId(), "Plank", LocalDateTime.of(2023, 12, 13, 15, 0), LocalDateTime.of(2023, 12, 13, 15, 5), 60, "Core");
        exercise3Person2.setDescription("Challenge yourself, hold it for a minute");
        exerciseHistoryService.addExercise(exercise3Person2);

        Exercise exercise4Person2 = new NoDistanceCardioExercise(person2.getId(), "Jumping Jacks", LocalDateTime.of(2023, 12, 14, 9, 0), LocalDateTime.of(2023, 12, 14, 9, 10), 200);
        exercise4Person2.setDescription("A classic cardio exercise to get your heart pumping");
        exerciseHistoryService.addExercise(exercise4Person2);

        Exercise exercise5Person2 = new BodyweightExercise(person2.getId(), "Push-ups", LocalDateTime.of(2023, 12, 15, 14, 0), LocalDateTime.of(2023, 12, 15, 14, 5), 150, 3, 10, "Chest");
        exercise5Person2.setDescription("Focus on controlled movements");
        exerciseHistoryService.addExercise(exercise5Person2);

        Exercise exercise6Person2 = new WeightLiftingExercise(person2.getId(), "Bicep Curls", LocalDateTime.of(2023, 12, 16, 9, 30), LocalDateTime.of(2023, 12, 16, 10, 15), 20, 3, 12, 20, "Arms");
        exercise6Person2.setEquipmentRequired("Dumbbells");
        exercise6Person2.setDescription("Isolate your biceps with controlled curls");
        exerciseHistoryService.addExercise(exercise6Person2);

        Exercise exercise7Person2 = new DistanceCardioExercise(person2.getId(), "Cycling", LocalDateTime.of(2023, 12, 17, 16, 0), LocalDateTime.of(2023, 12, 17, 17, 0), 400, 20.5);
        exercise7Person2.setDescription("Evening bike ride around the neighborhood");
        exerciseHistoryService.addExercise(exercise7Person2);

        Exercise exercise8Person2 = new IsometricExercise(person2.getId(), "Side Plank", LocalDateTime.of(2023, 12, 18, 14, 0), LocalDateTime.of(2023, 12, 18, 14, 3), 45, "Core");
        exercise8Person2.setDescription("Engage your core and maintain a straight line");
        exerciseHistoryService.addExercise(exercise8Person2);

        Exercise exercise9Person2 = new BodyweightExercise(person2.getId(), "Squats", LocalDateTime.of(2023, 12, 19, 11, 0), LocalDateTime.of(2023, 12, 19, 11, 15), 150, 3, 12, "Legs");
        exercise9Person2.setDescription("Focus on balance and controlled movements");
        exerciseHistoryService.addExercise(exercise9Person2);

        Exercise exercise10Person2 = new NoDistanceCardioExercise(person2.getId(), "Burpees", LocalDateTime.of(2023, 12, 20, 10, 0), LocalDateTime.of(2023, 12, 20, 10, 10), 150);
        exercise10Person2.setDescription("Full-body workout with explosive movements");
        exerciseHistoryService.addExercise(exercise10Person2);

        //Person11 exercises
        Exercise exercise1Person11 = new WeightLiftingExercise(person11.getId(), "Leg Press", LocalDateTime.of(2023, 12, 21, 10, 0), LocalDateTime.of(2023, 12, 21, 10, 30), 150, 4, 12, 60, "Legs");
        exercise1Person11.setEquipmentRequired("Leg press machine");
        exercise1Person11.setDescription("Adjust the seat for proper form and target your quads");
        exerciseHistoryService.addExercise(exercise1Person11);

        Exercise exercise2Person11 = new DistanceCardioExercise(person11.getId(), "Elliptical Training", LocalDateTime.of(2023, 12, 22, 8, 0), LocalDateTime.of(2023, 12, 22, 8, 45), 350, 15.0);
        exercise2Person11.setDescription("Low-impact cardio with resistance");
        exerciseHistoryService.addExercise(exercise2Person11);

        Exercise exercise3Person11 = new IsometricExercise(person11.getId(), "Plank", LocalDateTime.of(2023, 12, 23, 15, 0), LocalDateTime.of(2023, 12, 23, 15, 5), 60, "Core");
        exercise3Person11.setDescription("Hold the plank position for 1 minute");
        exerciseHistoryService.addExercise(exercise3Person11);

        Exercise exercise4Person11 = new NoDistanceCardioExercise(person11.getId(), "Jump Rope", LocalDateTime.of(2023, 12, 24, 9, 0), LocalDateTime.of(2023, 12, 24, 9, 10), 300);
        exercise4Person11.setDescription("Improve cardiovascular endurance with jump rope");
        exerciseHistoryService.addExercise(exercise4Person11);

        Exercise exercise5Person11 = new BodyweightExercise(person11.getId(), "Pull-ups", LocalDateTime.of(2023, 12, 25, 14, 0), LocalDateTime.of(2023, 12, 25, 14, 5), 0, 3, 8, "Back");
        exercise5Person11.setDescription("Use an overhand grip for targeting the upper back");
        exerciseHistoryService.addExercise(exercise5Person11);

        Exercise exercise6Person11 = new WeightLiftingExercise(person11.getId(), "Shoulder Press", LocalDateTime.of(2023, 12, 26, 9, 30), LocalDateTime.of(2023, 12, 26, 10, 15), 80, 4, 10, 45, "Shoulders");
        exercise6Person11.setEquipmentRequired("Dumbbells or barbell");
        exercise6Person11.setDescription("Avoid arching your back and use a controlled motion");
        exerciseHistoryService.addExercise(exercise6Person11);

        Exercise exercise7Person11 = new DistanceCardioExercise(person11.getId(), "Stationary Bike", LocalDateTime.of(2023, 12, 27, 16, 0), LocalDateTime.of(2023, 12, 27, 17, 0), 250, 12.0);
        exercise7Person11.setDescription("Adjust the resistance for an effective cycling session");
        exerciseHistoryService.addExercise(exercise7Person11);

        Exercise exercise8Person11 = new IsometricExercise(person11.getId(), "Side Plank", LocalDateTime.of(2023, 12, 28, 14, 0), LocalDateTime.of(2023, 12, 28, 14, 3), 45, "Core");
        exercise8Person11.setDescription("Engage your core and maintain a straight line");
        exerciseHistoryService.addExercise(exercise8Person11);

        Exercise exercise9Person11 = new BodyweightExercise(person11.getId(), "Squats", LocalDateTime.of(2023, 12, 29, 11, 0), LocalDateTime.of(2023, 12, 29, 11, 15), 80, 3, 15, "Legs");
        exercise9Person11.setDescription("Focus on balance and controlled movements");
        exerciseHistoryService.addExercise(exercise9Person11);

        Exercise exercise10Person11 = new NoDistanceCardioExercise(person11.getId(), "Mountain Climbers", LocalDateTime.of(2023, 12, 30, 10, 0), LocalDateTime.of(2023, 12, 30, 10, 10), 200);
        exercise10Person11.setDescription("Dynamic exercise for a full-body workout");
        exerciseHistoryService.addExercise(exercise10Person11);

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
