package fitnesstracker.services;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.repositories.HealthStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthStatisticService {

    private final HealthStatisticRepository healthStatisticRepository;
    private final MealService mealService;
    private final ExerciseHistoryService exerciseHistoryService;

    @Autowired
    public HealthStatisticService(HealthStatisticRepository healthStatisticRepository, MealService mealService, ExerciseHistoryService exerciseHistoryService) {
        this.healthStatisticRepository = healthStatisticRepository;
        this.exerciseHistoryService = exerciseHistoryService;
        this.mealService = mealService;
    }

    public boolean repoIsEmpty() {
        return healthStatisticRepository.findAll().isEmpty();
    }

    public List<HealthStatistic> getAllHealthStatistics() {
        return healthStatisticRepository.findAll();
    }

    public HealthStatistic getHealthStatisticById(Long id) {
        return healthStatisticRepository.findById(id).orElse(null);
    }

    public HealthStatistic createHealthStatistic(HealthStatistic healthStatistic) {
        List<Meal> meals = mealService.getMealByPersonIdAndDate(healthStatistic.getPersonId(), healthStatistic.getHealthDate());
        int calorieIn = healthStatistic.calculateCalorieInFromMeals(meals);
        healthStatistic.setCalorieIn(calorieIn);
        List<Exercise> exercises = exerciseHistoryService.findByPersonId(healthStatistic.getPersonId());
        int calorieOut = healthStatistic.calculateCalorieOutFromExercise(exercises);
        healthStatistic.setCalorieOut(calorieOut);

        return healthStatisticRepository.save(healthStatistic);
    }

    public void deleteHealthStatistic(Long id) {
        healthStatisticRepository.deleteById(id);
    }

    public boolean existsByPersonId(Long personId) {
        return healthStatisticRepository.existsByPersonId(personId);
    }
}
