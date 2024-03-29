package fitnesstracker.entities.exercise;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class BodyweightExercise extends StrengthTrainingExercise {

    public BodyweightExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, int sets, int reps, String targetMuscle) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned, sets, reps, targetMuscle);
        this.exerciseType = "BodyWeight Exercise";
    }

    public BodyweightExercise() {}

}

