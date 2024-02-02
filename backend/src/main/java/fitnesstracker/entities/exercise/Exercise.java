package fitnesstracker.entities.exercise;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Exercise {

    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Exercise ID", example = "1")
    private Long id;

    private LocalDateTime startInclusive;

    private LocalDateTime endExclusive;

    @Schema(description = "Name of exercise.", example = "bench press")
    protected String exerciseName;

    @Schema(description = "Equipment required for exercise.", example = "barbell")
    protected String equipmentRequired;

    @Schema(description = "Exercise start time.", example = "2023-12-01 11:00:00")
    protected LocalDateTime startTime;

    @Schema(description = "Exercise end time.", example = "2023-12-01 12:00:00")
    protected LocalDateTime endTime;

    @Schema(description = "Calories burned during exercise.", example = "200")
    protected Integer caloriesBurned;

    @Schema(description = "Description of exercise.", example = "Lie on a bench, grip a barbell, lower it to your chest, then push it back up. Keep your back on the bench and use a spotter for safety.")
    protected String description;

    @Column(name = "person_id")
    @Schema(description = "ID associated with person who completed exercise.", example = "1")
    private Long personId;


    //constructors
    public Exercise() {}
    public Exercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned) {
        this.exerciseName = exerciseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.personId = personId;
        this.caloriesBurned = caloriesBurned;
    }

    //getters
    public Long getId() {
        return id;
    }
    public Long getPersonId() {
        return personId;
    }
    public String getExerciseName() {
        return exerciseName;
    }
    public String getEquipmentRequired() {
        return equipmentRequired;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public Integer getCaloriesBurned() {
        return caloriesBurned;
    }
    public String getDescription() {
        return description;
    }
    public Duration getDuration() {
        if (startInclusive != null && endExclusive != null) {
            return Duration.between(startInclusive, endExclusive);
        }
        return Duration.ZERO; // or handle the null case appropriately
    }


    //setters

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
    public void setEquipmentRequired(String equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public void setCaloriesBurned(Integer caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStartInclusive(LocalDateTime startInclusive) {
        this.startInclusive = startInclusive;
    }
    public void setEndExclusive(LocalDateTime endExclusive) {
        this.endExclusive = endExclusive;
    }

    public String tokenizeExerciseName() {
        return exerciseName.toLowerCase().replace(" ", "_");
    }

}
