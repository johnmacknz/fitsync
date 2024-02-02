package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class WeightLiftingExerciseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WeightLiftingExercise#WeightLiftingExercise()}
     *   <li>{@link WeightLiftingExercise#setWeightInKg(double)}
     *   <li>{@link WeightLiftingExercise#getWeightInKg()}
     * </ul>
     */
    @Test
    void testConstructor() {
        WeightLiftingExercise actualWeightLiftingExercise = new WeightLiftingExercise();
        actualWeightLiftingExercise.setWeightInKg(10.0d);
        assertEquals(10.0d, actualWeightLiftingExercise.getWeightInKg());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link WeightLiftingExercise#WeightLiftingExercise(Long, String, LocalDateTime, LocalDateTime, Integer, int, int, double)}
     *   <li>{@link WeightLiftingExercise#setWeightInKg(double)}
     *   <li>{@link WeightLiftingExercise#getWeightInKg()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime startTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        WeightLiftingExercise actualWeightLiftingExercise = new WeightLiftingExercise(1L, "Exercise Name", startTime,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1, 1, 10.0d);
        actualWeightLiftingExercise.setWeightInKg(10.0d);
        assertEquals(10.0d, actualWeightLiftingExercise.getWeightInKg());
    }
}
