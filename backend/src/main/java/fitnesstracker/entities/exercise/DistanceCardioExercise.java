package fitnesstracker.entities.exercise;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class DistanceCardioExercise extends CardioExercise {

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }
    public DistanceCardioExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, double distanceInKm) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
        this.distanceInKm = distanceInKm;
        this.exerciseType = "Distance Cardio Exercise";
    }

    public DistanceCardioExercise() {}

}
