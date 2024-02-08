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

        Person admin = new Person("admin", "admin", "admin", "admin");
        personService.savePerson(admin);
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

        Exercise exercise9Person1 = new BodyweightExercise(person1.getId(), "Lunges", LocalDateTime.of(2023, 12, 9, 11, 0), LocalDateTime.of(2023, 12, 9, 11, 15), 50, 3, 12, "Legs");
        exercise9Person1.setDescription("Focus on balance and controlled movements");
        exerciseHistoryService.addExercise(exercise9Person1);

        Exercise exercise10Person1 = new NoDistanceCardioExercise(person1.getId(), "High Knees", LocalDateTime.of(2023, 12, 10, 10, 0), LocalDateTime.of(2023, 12, 10, 10, 10), 150);
        exercise10Person1.setDescription("Elevate your heart rate with high-intensity cardio");
        exerciseHistoryService.addExercise(exercise10Person1);

        Exercise exercise11Person1 = new WeightLiftingExercise(person1.getId(), "Squats", LocalDateTime.of(2023, 11, 1, 10, 0), LocalDateTime.of(2023, 11, 1, 11, 30), 210, 3, 10, 30, "Legs");
        exercise11Person1.setEquipmentRequired("Barbell and free weights");
        exercise11Person1.setDescription("Maintain proper form throughout");
        exerciseHistoryService.addExercise(exercise11Person1);

        Exercise exercise12Person1 = new WeightLiftingExercise(person1.getId(), "Squats", LocalDateTime.of(2023, 12, 23, 10, 0), LocalDateTime.of(2023, 12, 23, 10, 30), 250, 3, 10, 60, "Legs");
        exercise12Person1.setEquipmentRequired("Barbell and free weights");
        exercise12Person1.setDescription("Maintain proper form throughout");
        exerciseHistoryService.addExercise(exercise12Person1);

        Exercise exercise13Person1 = new WeightLiftingExercise(person1.getId(), "Bench Press", LocalDateTime.of(2023, 12, 24, 10, 0), LocalDateTime.of(2023, 12, 24, 11, 30), 250, 3, 10, 60, "Chest");
        exercise13Person1.setEquipmentRequired("Barbell and free weights");
        exercise13Person1.setDescription("Maintain proper form throughout");
        exerciseHistoryService.addExercise(exercise13Person1);

        Exercise exercise14Person1 = new WeightLiftingExercise(person1.getId(), "Bench Press", LocalDateTime.of(2024, 1, 20, 10, 0), LocalDateTime.of(2024, 1, 20, 11, 30), 250, 3, 10, 50, "Chest");
        exercise14Person1.setEquipmentRequired("Barbell and free weights");
        exercise14Person1.setDescription("Maintain proper form throughout");
        exerciseHistoryService.addExercise(exercise14Person1);

        Exercise exercise15Person1 = new WeightLiftingExercise(person1.getId(), "Bench Press", LocalDateTime.of(2024, 1, 27, 10, 0), LocalDateTime.of(2024, 1, 27, 11, 30), 200, 3, 10, 60, "Chest");
        exercise15Person1.setEquipmentRequired("Barbell and free weights");
        exercise15Person1.setDescription("Maintain proper form throughout");
        exerciseHistoryService.addExercise(exercise15Person1);

        Exercise exercise16Person1 = new DistanceCardioExercise(person1.getId(), "Running", LocalDateTime.of(2024, 2, 5, 7, 0), LocalDateTime.of(2024, 2, 5, 7, 45), 350, 10.0);
        exercise16Person1.setDescription("Change your pace throughout the run");
        exerciseHistoryService.addExercise(exercise16Person1);

        Exercise exercise17Person1 = new IsometricExercise(person1.getId(), "Plank", LocalDateTime.of(2024, 2, 6, 16, 0), LocalDateTime.of(2024, 2, 6, 16, 5), 75, "Core");
        exercise17Person1.setDescription("Focus on breathing and core engagement");
        exerciseHistoryService.addExercise(exercise17Person1);

        Exercise exercise18Person1 = new BodyweightExercise(person1.getId(), "Push-ups", LocalDateTime.of(2024, 2, 7, 13, 0), LocalDateTime.of(2024, 2, 7, 13, 5), 120, 3, 15, "Chest");
        exercise18Person1.setDescription("Maintain a straight body position");
        exerciseHistoryService.addExercise(exercise18Person1);

        Exercise exercise19Person1 = new DistanceCardioExercise(person1.getId(), "Cycling", LocalDateTime.of(2024, 2, 10, 15, 0), LocalDateTime.of(2024, 2, 10, 16, 0), 600, 30.0);
        exercise19Person1.setDescription("Find a challenging route with hills");
        exerciseHistoryService.addExercise(exercise19Person1);

        Exercise exercise20Person1 = new IsometricExercise(person1.getId(), "Side Plank", LocalDateTime.of(2024, 2, 11, 14, 0), LocalDateTime.of(2024, 2, 11, 14, 3), 60, "Core");
        exercise20Person1.setDescription("Focus on stability and controlled breathing");
        exerciseHistoryService.addExercise(exercise20Person1);

        Exercise exercise21Person1 = new BodyweightExercise(person1.getId(), "Lunges", LocalDateTime.of(2024, 2, 12, 10, 0), LocalDateTime.of(2024, 2, 12, 10, 15), 60, 3, 15, "Legs");
        exercise21Person1.setDescription("Step forward with purpose and control");
        exerciseHistoryService.addExercise(exercise21Person1);

        Exercise exercise22Person1 = new DistanceCardioExercise(person1.getId(), "Running", LocalDateTime.of(2024, 2, 15, 6, 30), LocalDateTime.of(2024, 2, 15, 7, 15), 300, 8.0);
        exercise22Person1.setDescription("Focus on steady pacing throughout");
        exerciseHistoryService.addExercise(exercise22Person1);

        Exercise exercise23Person1 = new IsometricExercise(person1.getId(), "Plank", LocalDateTime.of(2024, 2, 16, 17, 0), LocalDateTime.of(2024, 2, 16, 17, 5), 90, "Core");
        exercise23Person1.setDescription("Challenge yourself with extended duration");
        exerciseHistoryService.addExercise(exercise23Person1);

        Exercise exercise24Person1 = new BodyweightExercise(person1.getId(), "Push-ups", LocalDateTime.of(2024, 2, 17, 12, 0), LocalDateTime.of(2024, 2, 17, 12, 5), 180, 4, 12, "Chest");
        exercise24Person1.setDescription("Add an explosive push at the top");
        exerciseHistoryService.addExercise(exercise24Person1);


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
