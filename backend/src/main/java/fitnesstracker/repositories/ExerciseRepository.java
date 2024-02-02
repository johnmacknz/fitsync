package fitnesstracker.repositories;

import fitnesstracker.entities.exercise.Exercise;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExerciseRepository extends ListCrudRepository<Exercise, Long> {
    List<Exercise> findExerciseByExerciseNameIgnoreCase(String exerciseName);
    List<Exercise> findByPersonId(Long personId);
    List<Exercise> findExerciseByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName);
}
