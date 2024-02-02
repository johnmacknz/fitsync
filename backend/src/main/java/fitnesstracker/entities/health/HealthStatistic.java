package fitnesstracker.entities.health;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.meal.Meal;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Schema(description = "Health Statistics")
public class HealthStatistic {

    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Health Statistics ID", example = "1")
    private Long id;

    @Schema(description = "Date of the Health Statistics", example = "2020-01-01")
    private LocalDate healthDate;

    @Schema(description = "Sleep of the Health Statistics", example = "10")
    private double sleep;

    @Schema(description = "Weight of the Health Statistics", example = "10")
    private double weight;
    private double bloodPressure;
    private double hydration;
    private int calorieIn;
    private int calorieOut;
    private double heartRate;
    private double stress;

    @Column(name = "person_id")
    private Long personId;
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    public Long getPersonId() {
        return personId;
    }

    @Transient
    private int calculatedCalorieIn;
    public int getCalculatedCalorieOut() {
        return calculatedCalorieOut;
    }

    @Transient
    private int calculatedCalorieOut;
    public int getCalculatedCalorieIn() {
        return calculatedCalorieIn;
    }

    // constructors
    public HealthStatistic() {
    }

    public HealthStatistic(LocalDate healthDate, double sleep, double weight, double bloodPressure, double hydration, int calorieIn, double calorieOut, double heartRate, double stress, Long personId) {
        this.healthDate = healthDate != null ? healthDate : LocalDate.now();

        this.sleep = sleep;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.hydration = hydration;
        this.calorieIn = getCalculatedCalorieIn();
        this.calorieOut = getCalculatedCalorieOut();
        this.heartRate = heartRate;
        this.stress = stress;
        this.personId = personId;
    }

    // getters, and setters
    public Long getId() {
        return id;
    }

    public double getSleep() {
        return sleep;
    }

    public void setSleep(double sleep) {
        this.sleep = sleep;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getHydration() {
        return hydration;
    }

    public void setHydration(double hydration) {
        this.hydration = hydration;
    }

    public int getCalorieIn() {
        return calorieIn;
    }

    public void setCalorieIn(int calorieIn) {
        this.calorieIn = calorieIn;
    }

    public int getCalorieOut() {
        return calorieOut;
    }

    public void setCalorieOut(int calorieOut) {
        this.calorieOut = calorieOut;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getStress() {
        return stress;
    }

    public void setStress(double stress) {
        this.stress = stress;
    }

    public LocalDate getHealthDate() {
        return healthDate;
    }

    public void setHealthDate(LocalDate healthDate) {
        this.healthDate = healthDate;
    }

    public int calculateCalorieOutFromExercise(List<Exercise> exercises) {
        calculatedCalorieOut = 0;
        for (Exercise exercise : exercises) {
            if (exercise.getEndTime().toLocalDate().equals(getHealthDate())) {
                calculatedCalorieOut += exercise.getCaloriesBurned();
            }
        }
        return calculatedCalorieOut;
    }

    public int calculateCalorieInFromMeals(List<Meal> meals) {
        if (meals != null) {
            calculatedCalorieIn = meals.stream().mapToInt(Meal::getCalories).sum();
        }
        return calculatedCalorieIn;
    }
}

