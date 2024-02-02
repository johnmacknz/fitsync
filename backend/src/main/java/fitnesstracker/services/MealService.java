package fitnesstracker.services;

import fitnesstracker.entities.meal.Meal;
import fitnesstracker.exceptions.MealServiceException;
import fitnesstracker.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    MealRepository mealRepository;

    public boolean repoIsEmpty() {
        return mealRepository.findAll().isEmpty();
    }

    public List<Meal> findAll() {
        try {
            return this.mealRepository.findAll();
        } catch (Exception e) {
            throw new MealServiceException("An error occurred while fetching meals", e);
        }
    }

    public Meal getMealById(long mealId) {
        Optional<Meal> meal = this.mealRepository.findById(mealId);
        return meal.orElse(null);
    }

    public Meal saveMeal(Meal meal) {
        if (meal == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        return this.mealRepository.save(meal);
    }

    public List<Meal> getMealByPersonIdAndDate(Long id, LocalDate date) {
        return this.mealRepository.findByPersonIdAndMealDate(id, date);
    }
}
