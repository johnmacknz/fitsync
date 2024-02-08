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

        String imagePath1 = "src/main/resources/chicken-stir-fry-1.jpg";
        byte[] imageData1 = readImageDataFromFile(imagePath1);

        String[] meal1IngredientNames = {"500 grams chicken breast", "Assorted vegetables (bell peppers, broccoli, carrots)", "3 tablespoons Soy Sauce", "2 tablespoons Olive oil", "2 cloves Garlic (minced)", "1 teaspoon Ginger (minced)", "1 tablespoon Cornstarch", "1 tablespoon Water", "Salt and pepper to taste"};

        Meal chickenStirFry = new Meal(
                null,
                "Chicken Stir Fry",
                "Lunch",
                500,
                "Heat a large skillet or wok over medium-high heat. Add a tablespoon of vegetable oil and swirl to coat the pan. Once hot, add the sliced chicken and stir-fry until golden brown and cooked through, about 5-6 minutes. Remove the chicken from the pan and set aside. In the same pan, add another tablespoon of oil and toss in the sliced bell peppers, broccoli florets, and snap peas. Stir-fry for 3-4 minutes until the vegetables are tender yet crisp. Return the cooked chicken to the pan and pour in the soy sauce mixture. Cook for an additional 1-2 minutes, tossing everything together until well combined and heated through. Serve hot over steamed rice and garnish with sesame seeds and sliced green onions.",
                person1.getId(),
                imageData1,
                "30 minutes",
                "Beginner",
                "2"
        );
        saveMeal(meal1IngredientNames, chickenStirFry);
        //*******************************************************************************

        //*******************************************************************************
        String[] meal2IngredientNames = {"500 grams Salmon fillet", "Assorted salad greens (lettuce, spinach, arugula)", "1 Lemon (sliced)", "2 tablespoons Olive oil", "1 teaspoon Dijon mustard", "1 tablespoon Honey", "Salt and pepper to taste"};

        Meal salmonSalad = new Meal(
                null,
                "Salmon Salad",
                "Dinner",
                400,
                "Preheat your grill to medium-high heat. In a small bowl, whisk together the olive oil, lemon juice, Dijon mustard, honey, salt, and pepper to create the dressing. Brush both sides of the salmon fillets with the dressing. Grill the salmon for 4-5 minutes on each side, or until it flakes easily with a fork. Remove from the grill and let it cool slightly. Meanwhile, toss the assorted salad greens with the remaining dressing in a large bowl. Divide the dressed greens among serving plates and top each with a grilled salmon fillet. Garnish with lemon slices and serve immediately.",
                person1.getId(),
                imageData1,
                "30 minutes",
                "Beginner",
                "2"
        );
        saveMeal(meal2IngredientNames, salmonSalad);
        //*******************************************************************************

        //*******************************************************************************
        String[] meal3IngredientNames = {"400 grams Spaghetti", "2 cups Tomato sauce", "Assorted vegetables (mushrooms, bell peppers, onions)", "200 grams Cheese (cheddar or mozzarella)", "2 tablespoons Olive oil", "2 cloves Garlic (minced)", "1 teaspoon Italian seasoning", "Salt and pepper to taste"};

        Meal vegetarianPasta = new Meal(
                null,
                "Vegetarian Pasta",
                "Dinner",
                600,
                "Bring a large pot of salted water to a boil. Cook the spaghetti according to the package instructions until al dente, then drain and set aside. In a separate skillet, heat the olive oil over medium heat. Add the minced garlic and sauté for 1-2 minutes until fragrant. Add the assorted vegetables to the skillet and cook for 4-5 minutes until they start to soften. Pour in the tomato sauce and Italian seasoning, then stir to combine. Let the sauce simmer for 5-7 minutes until heated through and slightly thickened. Add the cooked spaghetti to the skillet and toss to coat in the sauce. Sprinkle grated cheese over the top and stir until melted. Season with salt and pepper to taste. Serve hot with a sprinkle of fresh basil leaves, if desired.",
                person1.getId(),
                imageData1,
                "30 minutes",
                "Beginner",
                "2"
        );
        saveMeal(meal3IngredientNames, vegetarianPasta);
        //*******************************************************************************

        //*******************************************************************************
        String[] meal4IngredientNames = {"1 kg Beef (sirloin or tenderloin)", "Assorted vegetables (zucchini, bell peppers, onions)", "4 tablespoons Teriyaki sauce", "3 tablespoons Olive oil", "4 cloves Garlic (minced)", "1 tablespoon Sesame seeds", "2 tablespoons Soy sauce", "1 tablespoon Cornstarch", "Salt and pepper to taste"};

        Meal teriyakiBeefStirFry = new Meal(
                null,
                "Teriyaki Beef Stir Fry",
                "Dinner",
                700,
                "In a small bowl, whisk together the teriyaki sauce, soy sauce, honey, minced garlic, and sesame seeds. Set aside. Heat a tablespoon of olive oil in a large skillet or wok over high heat. Add the sliced beef strips and stir-fry for 2-3 minutes until browned on all sides. Remove the beef from the skillet and set aside. In the same skillet, add another tablespoon of oil and toss in the sliced bell peppers, onions, and zucchini. Stir-fry for 3-4 minutes until the vegetables are tender yet crisp. Return the cooked beef to the skillet and pour the teriyaki sauce mixture over the top. Cook for an additional 1-2 minutes, stirring constantly, until the sauce thickens and coats the beef and vegetables. Serve hot over steamed rice and garnish with sliced green onions and sesame seeds.",
                person1.getId(),
                imageData1,
                "40 minutes",
                "Intermediate",
                "4"
        );
        saveMeal(meal4IngredientNames, teriyakiBeefStirFry);
//*******************************************************************************

//*******************************************************************************
        String[] meal5IngredientNames = {"800 grams Chicken thighs (boneless, skinless)", "1 cup Greek yogurt", "2 tablespoons Lemon juice", "4 cloves Garlic (minced)", "1 tablespoon Paprika", "1 tablespoon Cumin", "1 teaspoon Cayenne pepper", "Salt and pepper to taste"};

        Meal grilledChickenTacos = new Meal(
                null,
                "Grilled Chicken Tacos",
                "Dinner",
                600,
                "Preheat your grill to medium-high heat. In a small bowl, whisk together the Greek yogurt, lemon juice, minced garlic, paprika, cumin, cayenne pepper, salt, and pepper to create the marinade. Place the chicken thighs in a shallow dish and pour the marinade over them, making sure they are evenly coated. Cover and refrigerate for at least 30 minutes to marinate. Remove the chicken from the marinade and grill for 6-8 minutes on each side, or until cooked through and grill marks appear. Transfer the grilled chicken to a cutting board and let it rest for a few minutes before slicing. To assemble the tacos, warm the tortillas on the grill for 20-30 seconds on each side. Fill each tortilla with sliced grilled chicken, fresh salsa, avocado slices, and a dollop of cilantro-lime crema. Serve immediately with lime wedges on the side.",
                person1.getId(),
                imageData1,
                "35 minutes",
                "Intermediate",
                "4"
        );
        saveMeal(meal5IngredientNames, grilledChickenTacos);
//*******************************************************************************

//*******************************************************************************
        String[] meal6IngredientNames = {"600 grams Shrimp (peeled and deveined)", "1/2 cup Barbecue sauce", "2 tablespoons Honey", "1 tablespoon Lime juice", "1 teaspoon Chili powder", "1/2 teaspoon Garlic powder", "1/2 teaspoon Onion powder", "Salt and pepper to taste"};

        Meal barbecueShrimpSkewers = new Meal(
                null,
                "BBQ Shrimp Skewers",
                "Dinner",
                450,
                "Preheat your grill to medium heat. In a small bowl, whisk together the barbecue sauce, honey, lime juice, chili powder, garlic powder, and onion powder to create the marinade. Thread the peeled and deveined shrimp onto skewers, then brush them generously with the marinade. Grill the shrimp skewers for 2-3 minutes on each side, or until they are pink and opaque. Remove from the grill and sprinkle with chopped fresh parsley. Serve hot with extra barbecue sauce for dipping and lemon wedges on the side.",
                person1.getId(),
                imageData1,
                "25 minutes",
                "Beginner",
                "2"
        );
        saveMeal(meal6IngredientNames, barbecueShrimpSkewers);
//*******************************************************************************

//*******************************************************************************
        String[] meal7IngredientNames = {"400 grams Firm tofu", "1/4 cup Soy sauce", "2 tablespoons Maple syrup", "2 tablespoons Rice vinegar", "2 cloves Garlic (minced)", "1 tablespoon Ginger (minced)", "1 tablespoon Cornstarch", "2 tablespoons Water", "2 tablespoons Sesame oil"};

        Meal mapleGlazedTofu = new Meal(
                null,
                "Maple Glazed Tofu",
                "Dinner",
                350,
                "Preheat your oven to 400°F (200°C). Drain the firm tofu and pat it dry with paper towels. Cut the tofu into cubes and place them on a baking sheet lined with parchment paper. In a small bowl, whisk together the soy sauce, maple syrup, rice vinegar, minced garlic, and minced ginger to create the marinade. Pour the marinade over the tofu cubes, making sure they are evenly coated. Bake in the preheated oven for 25-30 minutes, flipping halfway through, until the tofu is golden and crispy. Meanwhile, prepare steamed rice and stir-fried vegetables as desired. Once the tofu is done, remove it from the oven and let it cool slightly. Serve the maple glazed tofu hot with the steamed rice and vegetables, drizzling any remaining marinade over the top as a sauce.",
                person1.getId(),
                imageData1,
                "40 minutes",
                "Intermediate",
                "3"
        );
        saveMeal(meal7IngredientNames, mapleGlazedTofu);
//*******************************************************************************

//*******************************************************************************
        String[] meal8IngredientNames = {"500 grams Pork tenderloin", "Assorted bell peppers (red, yellow, green)", "1 Onion (sliced)", "1/4 cup Hoisin sauce", "2 tablespoons Soy sauce", "1 tablespoon Rice vinegar", "1 tablespoon Honey", "2 cloves Garlic (minced)", "1 tablespoon Cornstarch"};

        Meal porkStirFryHoisin = new Meal(
                null,
                "Pork Stir Fry",
                "Dinner",
                550,
                "THeat a tablespoon of sesame oil in a large skillet or wok over high heat. Add the sliced pork tenderloin and stir-fry for 2-3 minutes until browned on all sides. Remove the pork from the skillet and set aside. In the same skillet, add another tablespoon of oil and toss in the sliced bell peppers and onions. Stir-fry for 3-4 minutes until the vegetables are tender yet crisp. Return the cooked pork to the skillet and pour the hoisin sauce mixture over the top. Cook for an additional 1-2 minutes, tossing everything together until well combined and heated through. Serve hot over steamed rice and garnish with sliced green onions and sesame seeds.",
                person1.getId(),
                imageData1,
                "35 minutes",
                "Intermediate",
                "3"
        );
        saveMeal(meal8IngredientNames, porkStirFryHoisin);
//*******************************************************************************

//*******************************************************************************
        String[] meal9IngredientNames = {"600 grams Lamb shoulder (cut into cubes)", "2 cups Yogurt", "1 Lemon (juiced)", "4 cloves Garlic (minced)", "2 teaspoons Ground cumin", "2 teaspoons Ground coriander", "1 teaspoon Paprika", "1/2 teaspoon Cayenne pepper", "Salt and pepper to taste"};

        Meal yogurtMarinatedLamb = new Meal(
                null,
                "Marinated Lamb",
                "Dinner",
                700,
                "In a large bowl, whisk together the yogurt, lemon juice, minced garlic, ground cumin, ground coriander, paprika, cayenne pepper, salt, and pepper to create the marinade. Add the cubed lamb shoulder to the bowl and toss to coat in the marinade. Cover and refrigerate for at least 2 hours, or preferably overnight, to marinate. Preheat your grill to medium-high heat. Thread the marinated lamb cubes onto skewers, then grill for 8-10 minutes, turning occasionally, until cooked to your desired doneness. Remove from the grill and let the skewers rest for a few minutes before serving. Serve the yogurt-marinated lamb skewers hot with couscous and roasted vegetables.",
                person1.getId(),
                imageData1,
                "50 minutes",
                "Advanced",
                "4"
        );
        saveMeal(meal9IngredientNames, yogurtMarinatedLamb);
//*******************************************************************************

//*******************************************************************************
        String[] meal10IngredientNames = {"800 grams Cod fillets", "1 cup Panko breadcrumbs", "2 tablespoons Parmesan cheese (grated)", "1 tablespoon Lemon zest", "1 tablespoon Fresh parsley (chopped)", "2 Eggs (beaten)", "1/4 cup All-purpose flour", "Salt and pepper to taste"};

        Meal crispyBakedCod = new Meal(
                null,
                "Crispy Baked Cod",
                "Dinner",
                400,
                "Preheat your oven to 400°F (200°C). In a shallow dish, combine the panko breadcrumbs, grated Parmesan cheese, lemon zest, chopped fresh parsley, salt, and pepper. Pat the cod fillets dry with paper towels, then dredge them in the flour, shaking off any excess. Dip each fillet into the beaten eggs, then coat evenly with the breadcrumb mixture, pressing gently to adhere. Place the coated cod fillets on a baking sheet lined with parchment paper. Bake in the preheated oven for 15-20 minutes, or until the fish is cooked through and the coating is golden and crispy. Serve the crispy baked cod hot with roasted potatoes and green beans on the side.",
                person1.getId(),
                imageData1,
                "30 minutes",
                "Intermediate",
                "3"
        );
        saveMeal(meal10IngredientNames, crispyBakedCod);
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
                double randomWeight = getRandomDoubleInRange(20.0, 30.0);
                double randomBloodPressure = getRandomDoubleInRange(60.0, 90.0);
                double randomHydration = getRandomDoubleInRange(70.0, 100.0);
                double randomCalorieIn = getRandomDoubleInRange(1500.0, 3000.0);
                double randomCalorieOut = getRandomDoubleInRange(1000.0, 2500.0);
                double randomHeartRate = getRandomDoubleInRange(60.0, 100.0);
                double randomStress = getRandomDoubleInRange(0.0, 20.0);

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
        }HealthStatistic healthStatistic11 = new HealthStatistic(null, 32.0, 69.0, 89.0, 99.0, 0, 0, 74.0, 19.0, person11.getId());
        healthStatisticService.createHealthStatistic(healthStatistic11);
//*******************************************************************************************
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
