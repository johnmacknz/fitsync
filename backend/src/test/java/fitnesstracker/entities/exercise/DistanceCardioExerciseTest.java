package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class DistanceCardioExerciseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DistanceCardioExercise#DistanceCardioExercise()}
     *   <li>{@link DistanceCardioExercise#setDistanceInKm(double)}
     *   <li>{@link DistanceCardioExercise#getDistanceInKm()}
     * </ul>
     */
    @Test
    void testConstructor() {
        DistanceCardioExercise actualDistanceCardioExercise = new DistanceCardioExercise();
        actualDistanceCardioExercise.setDistanceInKm(10.0d);
        assertEquals(10.0d, actualDistanceCardioExercise.getDistanceInKm());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link DistanceCardioExercise#DistanceCardioExercise(Long, String, LocalDateTime, LocalDateTime, Integer, double)}
     *   <li>{@link DistanceCardioExercise#setDistanceInKm(double)}
     *   <li>{@link DistanceCardioExercise#getDistanceInKm()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime startTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        DistanceCardioExercise actualDistanceCardioExercise = new DistanceCardioExercise(1L, "Exercise Name", startTime,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 10.0d);
        actualDistanceCardioExercise.setDistanceInKm(10.0d);
        assertEquals(10.0d, actualDistanceCardioExercise.getDistanceInKm());
    }
}
