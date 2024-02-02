package fitnesstracker.services;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.exceptions.ExerciseServiceException;
import fitnesstracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseHistoryService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseHistoryService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public boolean repoIsEmpty() {
        return exerciseRepository.findAll().isEmpty();
    }

    public List<Exercise> findAll() {
        try {
            return this.exerciseRepository.findAll();
        } catch (Exception e) {
            throw new ExerciseServiceException("An error occurred while fetching exercises", e);
        }
    }

    public Exercise getExerciseById(long exerciseId){
        Optional<Exercise> exercise = this.exerciseRepository.findById(exerciseId);
        return exercise.orElse(null);
    }

    public Exercise addExercise(Exercise name){
        if (name == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        return this.exerciseRepository.save(name);
    }

    public void deleteById(long id) {
       exerciseRepository.deleteById(id);
    }

    public List<Exercise> getExerciseByName(String exerciseName) {
        return this.exerciseRepository.findExerciseByExerciseNameIgnoreCase(exerciseName);
    }

    public List<Exercise> findByPersonId(Long personId) {
        return exerciseRepository.findByPersonId(personId);
    }

    public List<Exercise> findExerciseByPersonIdAndExerciseName(Long personId, String exerciseName) {
        return exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
    }
}
