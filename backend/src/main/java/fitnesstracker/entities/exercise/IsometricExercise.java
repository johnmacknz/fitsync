package fitnesstracker.entities.exercise;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class IsometricExercise extends Exercise {

    @Schema(description = "Short description of target muscle(s) of exercise.", example = "Chest, shoulders, and triceps.")
    String targetMuscle;
    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public IsometricExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
    }

    public IsometricExercise() {}
}
