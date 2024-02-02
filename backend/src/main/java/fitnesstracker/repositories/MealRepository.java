package fitnesstracker.repositories;

import fitnesstracker.entities.meal.Meal;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends ListCrudRepository<Meal, Long> {
    List<Meal> findByPersonIdAndMealDate(Long personId, LocalDate date);
}
