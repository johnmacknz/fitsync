package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class IsometricExerciseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link IsometricExercise#IsometricExercise()}
     *   <li>{@link IsometricExercise#setTargetMuscle(String)}
     *   <li>{@link IsometricExercise#getTargetMuscle()}
     * </ul>
     */
    @Test
    void testConstructor() {
        IsometricExercise actualIsometricExercise = new IsometricExercise();
        actualIsometricExercise.setTargetMuscle("Target Muscle");
        assertEquals("Target Muscle", actualIsometricExercise.getTargetMuscle());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link IsometricExercise#IsometricExercise(Long, String, LocalDateTime, LocalDateTime, Integer)}
     *   <li>{@link IsometricExercise#setTargetMuscle(String)}
     *   <li>{@link IsometricExercise#getTargetMuscle()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime startTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        IsometricExercise actualIsometricExercise = new IsometricExercise(1L, "Exercise Name", startTime,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1);
        actualIsometricExercise.setTargetMuscle("Target Muscle");
        assertEquals("Target Muscle", actualIsometricExercise.getTargetMuscle());
    }
}
