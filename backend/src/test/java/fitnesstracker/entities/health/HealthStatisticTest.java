package fitnesstracker.entities.health;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.meal.Meal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class HealthStatisticTest {

    @Test
    void testCalculateCalorieOutFromExercise() {

        HealthStatistic healthStatistic = new HealthStatistic();
        healthStatistic.setHealthDate(LocalDate.now());

        List<Exercise> exercises = new ArrayList<>();
        Exercise exercise1 = new Exercise();
        exercise1.setCaloriesBurned(100);
        exercise1.setEndTime(LocalDateTime.now());
        exercises.add(exercise1);

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(150);
        exercise2.setEndTime(LocalDateTime.now());
        exercises.add(exercise2);

        int calculatedCalorieOut = healthStatistic.calculateCalorieOutFromExercise(exercises);

        assertEquals(250, calculatedCalorieOut);
    }

    @Test
    void testCalculateCalorieInFromMeals() {
        HealthStatistic healthStatistic = new HealthStatistic();

        List<Meal> meals = new ArrayList<>();
        Meal meal1 = new Meal();
        meal1.setCalories(300);
        meals.add(meal1);

        Meal meal2 = new Meal();
        meal2.setCalories(200);
        meals.add(meal2);

        Meal meal3 = new Meal();
        meal3.setCalories(150);
        meals.add(meal3);

        int calculatedCalorieIn = healthStatistic.calculateCalorieInFromMeals(meals);

        assertEquals(650, calculatedCalorieIn);
    }

    @Test
    void testDefaultConstructor() {
        HealthStatistic healthStatistic = new HealthStatistic();

        Assertions.assertNotNull(healthStatistic);

        assertNull(healthStatistic.getHealthDate());
    }

    @Test
    void testParameterizedConstructor() {
        LocalDate date = LocalDate.of(2022, 1, 15);
        double sleep = 7.5;
        double weight = 70.5;
        double bloodPressure = 120.0;
        double hydration = 60.0;
        int calorieIn = 800;
        double calorieOut = 300;
        double heartRate = 75.0;
        double stress = 5.0;
        Long personId = 1L;

        HealthStatistic healthStatistic = new HealthStatistic(date, sleep, weight, bloodPressure, hydration, calorieIn, calorieOut, heartRate, stress, personId);

        Assertions.assertNotNull(healthStatistic);

        assertEquals(date, healthStatistic.getHealthDate());
        assertEquals(sleep, healthStatistic.getSleep());
        assertEquals(weight, healthStatistic.getWeight());
        assertEquals(bloodPressure, healthStatistic.getBloodPressure());
        assertEquals(hydration, healthStatistic.getHydration());
        assertEquals(0, healthStatistic.getCalorieIn());
        assertEquals(0, healthStatistic.getCalorieOut());
        assertEquals(heartRate, healthStatistic.getHeartRate());
        assertEquals(stress, healthStatistic.getStress());
        assertEquals(personId, healthStatistic.getPersonId());
    }

    @Test
    void testSetters() {
        HealthStatistic healthStatistic = new HealthStatistic();

        healthStatistic.setSleep(8.0);
        healthStatistic.setWeight(72.0);
        healthStatistic.setBloodPressure(110.0);
        healthStatistic.setHydration(65.0);
        healthStatistic.setCalorieIn(900);
        healthStatistic.setCalorieOut(400);
        healthStatistic.setHeartRate(80.0);
        healthStatistic.setStress(6.0);
        healthStatistic.setPersonId(5L);

        assertEquals(8.0, healthStatistic.getSleep());
        assertEquals(72.0, healthStatistic.getWeight());
        assertEquals(110.0, healthStatistic.getBloodPressure());
        assertEquals(65.0, healthStatistic.getHydration());
        assertEquals(900, healthStatistic.getCalorieIn());
        assertEquals(400.0, healthStatistic.getCalorieOut());
        assertEquals(80.0, healthStatistic.getHeartRate());
        assertEquals(6.0, healthStatistic.getStress());
        assertEquals(5L, healthStatistic.getPersonId());
        assertNull(healthStatistic.getId());
    }
}
