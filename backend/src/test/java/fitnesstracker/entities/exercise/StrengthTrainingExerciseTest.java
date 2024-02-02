package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class StrengthTrainingExerciseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StrengthTrainingExercise#StrengthTrainingExercise()}
     *   <li>{@link StrengthTrainingExercise#setReps(int)}
     *   <li>{@link StrengthTrainingExercise#setSets(int)}
     *   <li>{@link StrengthTrainingExercise#setTargetMuscle(String)}
     *   <li>{@link StrengthTrainingExercise#getReps()}
     *   <li>{@link StrengthTrainingExercise#getSets()}
     *   <li>{@link StrengthTrainingExercise#getTargetMuscle()}
     * </ul>
     */
    @Test
    void testConstructor() {
        StrengthTrainingExercise actualStrengthTrainingExercise = new StrengthTrainingExercise();
        actualStrengthTrainingExercise.setReps(1);
        actualStrengthTrainingExercise.setSets(1);
        actualStrengthTrainingExercise.setTargetMuscle("Target Muscle");
        int actualReps = actualStrengthTrainingExercise.getReps();
        int actualSets = actualStrengthTrainingExercise.getSets();
        assertEquals("Target Muscle", actualStrengthTrainingExercise.getTargetMuscle());
        assertEquals(1, actualReps);
        assertEquals(1, actualSets);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link StrengthTrainingExercise#StrengthTrainingExercise(Long, String, LocalDateTime, LocalDateTime, Integer, int, int)}
     *   <li>{@link StrengthTrainingExercise#setReps(int)}
     *   <li>{@link StrengthTrainingExercise#setSets(int)}
     *   <li>{@link StrengthTrainingExercise#setTargetMuscle(String)}
     *   <li>{@link StrengthTrainingExercise#getReps()}
     *   <li>{@link StrengthTrainingExercise#getSets()}
     *   <li>{@link StrengthTrainingExercise#getTargetMuscle()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime startTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        StrengthTrainingExercise actualStrengthTrainingExercise = new StrengthTrainingExercise(1L, "Exercise Name",
                startTime, LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1, 1);
        actualStrengthTrainingExercise.setReps(1);
        actualStrengthTrainingExercise.setSets(1);
        actualStrengthTrainingExercise.setTargetMuscle("Target Muscle");
        int actualReps = actualStrengthTrainingExercise.getReps();
        int actualSets = actualStrengthTrainingExercise.getSets();
        assertEquals("Target Muscle", actualStrengthTrainingExercise.getTargetMuscle());
        assertEquals(1, actualReps);
        assertEquals(1, actualSets);
    }
}
