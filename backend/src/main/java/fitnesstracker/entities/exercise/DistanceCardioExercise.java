package fitnesstracker.entities.exercise;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class DistanceCardioExercise extends CardioExercise {

    @Schema(description = "Distance travelled during exercise in kilometres.", example = "5")
    private double distanceInKm;

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }
    public DistanceCardioExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, double distanceInKm) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
        this.distanceInKm = distanceInKm;
    }

    public DistanceCardioExercise() {}
}
