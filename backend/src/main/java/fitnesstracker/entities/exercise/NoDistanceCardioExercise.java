package fitnesstracker.entities.exercise;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class NoDistanceCardioExercise extends CardioExercise {
    public NoDistanceCardioExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
    }

    public NoDistanceCardioExercise() {}
}
