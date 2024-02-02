package fitnesstracker.entities.exercise;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class WeightLiftingExercise extends StrengthTrainingExercise {

    @Schema(description = "Weight lifted during exercise in kilograms.", example = "60")
    private double weightInKg;

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public WeightLiftingExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, int sets, int reps, double weightInKg) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned, sets, reps);
        this.weightInKg = weightInKg;
    }

    public WeightLiftingExercise() {}
}
