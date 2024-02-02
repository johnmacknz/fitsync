package fitnesstracker.entities.exercise;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;


@MappedSuperclass
public class CardioExercise extends Exercise {

    public CardioExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
    }

    public CardioExercise() {}
}
