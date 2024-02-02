package fitnesstracker.config;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.health.HealthStatistic;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestUtilities {

    static Person person1 = new Person(1L, "Bob", "bob123", "password1");

//    public static @NotNull ArrayList<Meal> getMealList() {
//        ArrayList<Meal> meals = new ArrayList<>();
//        Meal meal1 = new Meal(null, "Chicken Stir Fry", "Lunch", 500, "Stir-fry chicken with vegetables and soy sauce", new ArrayList<>(), person1.getId());
//        meal1.getIngredients().add(new Ingredient((Set<Meal>) meal1, "Chicken"));
//        meal1.getIngredients().add(new Ingredient((Set<Meal>) meal1, "Vegetables"));
//        meal1.getIngredients().add(new Ingredient((Set<Meal>) meal1, "Soy Sauce"));
//
//        Meal meal2 = new Meal(null, "Salmon Salad", "Dinner", 400, "Grilled salmon served with a fresh salad", new ArrayList<>(), person1.getId());
//        meal2.getIngredients().add(new Ingredient((Set<Meal>) meal2, "Salmon"));
//        meal2.getIngredients().add(new Ingredient((Set<Meal>) meal2, "Fresh Salad"));
//
//        Meal meal3 = new Meal(null, "Vegetarian Pasta", "Dinner", 600, "Pasta with tomato sauce, vegetables, and cheese", new ArrayList<>(), person1.getId());
//        meal3.getIngredients().add(new Ingredient((Set<Meal>) meal3, "Pasta"));
//        meal3.getIngredients().add(new Ingredient((Set<Meal>) meal3, "Tomato Sauce"));
//        meal3.getIngredients().add(new Ingredient((Set<Meal>) meal3, "Vegetables"));
//        meal3.getIngredients().add(new Ingredient((Set<Meal>) meal3, "Cheese"));
//
//        meals.add(meal1);
//        meals.add(meal2);
//        meals.add(meal3);
//        return meals;
//    }


    public static @NotNull List<Exercise> getExerciseList() {
        Exercise exercise1 = new Exercise(1L, "running", LocalDateTime.of(2020, 12, 3, 3, 30), LocalDateTime.of(2020, 12, 3, 3, 59), 100);
        Exercise exercise2 = new Exercise(123L, "Weights", LocalDateTime.of(2020, 12, 3, 3, 30), LocalDateTime.of(2020, 12, 3, 3, 59), 100);
        Exercise exercise3 = new Exercise(134L, "running", LocalDateTime.of(2020, 12, 3, 3, 30), LocalDateTime.of(2020, 12, 3, 3, 59), 100);
        ArrayList<Exercise> exercises = new ArrayList<>();

        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);
        return exercises;
    }
    public static @NotNull List<HealthStatistic> getStatsList() {
        Person person2 = new Person(1L, "Tom", "tom123", "password1");
        ArrayList<HealthStatistic> healthStatistics = new ArrayList<>();
        HealthStatistic healthStatistic1 = new HealthStatistic(null, 23.0, 60.0, 80.0, 90.0, 0, 0, 65.0, 10.0, person2.getId());
        HealthStatistic healthStatistic2 = new HealthStatistic(null, 24.0, 61.0, 81.0, 91.0, 0, 0, 66.0, 11.0, person2.getId());
        HealthStatistic healthStatistic3 = new HealthStatistic(null, 24.0, 61.0, 81.0, 91.0, 0, 0, 66.0, 11.0, person2.getId());
        HealthStatistic healthStatistic4 = new HealthStatistic(null, 24.0, 61.0, 81.0, 91.0, 0, 0, 66.0, 11.0, person2.getId());

        healthStatistics.add(healthStatistic1);
        healthStatistics.add(healthStatistic2);
        healthStatistics.add(healthStatistic3);
        healthStatistics.add(healthStatistic4);
        return healthStatistics;
    }
  }

