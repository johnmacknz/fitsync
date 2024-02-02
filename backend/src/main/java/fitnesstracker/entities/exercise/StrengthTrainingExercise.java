package fitnesstracker.entities.exercise;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class StrengthTrainingExercise extends Exercise {

    @Schema(description = "Number of sets completed of exercise.", example = "3")
    protected int sets;

    @Schema(description = "Number of reps completed of exercise.", example = "10")
    protected int reps;

    @Schema(description = "Short description of target muscle(s) of exercise.", example = "Chest, shoulders, and triceps.")
    protected String targetMuscle;

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public StrengthTrainingExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, int sets, int reps) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
        this.sets = sets;
        this.reps = reps;
    }

    public StrengthTrainingExercise() {}
}
