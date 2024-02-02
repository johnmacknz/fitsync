package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class BodyweightExerciseTest {
    /**
     * Method under test: {@link BodyweightExercise#BodyweightExercise()}
     */
    @Test
    void testConstructor() {
        BodyweightExercise actualBodyweightExercise = new BodyweightExercise();
        assertNull(actualBodyweightExercise.getCaloriesBurned());
        assertNull(actualBodyweightExercise.getId());
        assertNull(actualBodyweightExercise.getPersonId());
        assertNull(actualBodyweightExercise.getDescription());
        assertNull(actualBodyweightExercise.getEquipmentRequired());
        assertNull(actualBodyweightExercise.getExerciseName());
        assertNull(actualBodyweightExercise.getTargetMuscle());
        assertNull(actualBodyweightExercise.getEndTime());
        assertNull(actualBodyweightExercise.getStartTime());
        assertEquals(0, actualBodyweightExercise.getReps());
        assertEquals(0, actualBodyweightExercise.getSets());
        assertEquals(0L, actualBodyweightExercise.getDuration().toNanos());
    }

    /**
     * Method under test:
     * {@link BodyweightExercise#BodyweightExercise(Long, String, LocalDateTime, LocalDateTime, Integer, int, int)}
     */
    @Test
    void testConstructor2() {
        LocalDate ofResult = LocalDate.of(1970, 1, 1);
        LocalDateTime startTime = ofResult.atStartOfDay();
        LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
        BodyweightExercise actualBodyweightExercise = new BodyweightExercise(1L, "Exercise Name", startTime,
                ofResult2.atStartOfDay(), 1, 1, 1);

        LocalDateTime endTime = actualBodyweightExercise.getEndTime();
        assertEquals("00:00", endTime.toLocalTime().toString());
        LocalDateTime startTime2 = actualBodyweightExercise.getStartTime();
        assertEquals("00:00", startTime2.toLocalTime().toString());
        LocalDate toLocalDateResult = endTime.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult.toString());
        LocalDate toLocalDateResult2 = startTime2.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult2.toString());
        assertEquals("Exercise Name", actualBodyweightExercise.getExerciseName());
        assertNull(actualBodyweightExercise.getId());
        assertNull(actualBodyweightExercise.getDescription());
        assertNull(actualBodyweightExercise.getEquipmentRequired());
        assertNull(actualBodyweightExercise.getTargetMuscle());
        assertEquals(0L, actualBodyweightExercise.getDuration().toNanos());
        assertEquals(1, actualBodyweightExercise.getReps());
        assertEquals(1, actualBodyweightExercise.getSets());
        assertEquals(1, actualBodyweightExercise.getCaloriesBurned().intValue());
        assertEquals(1L, actualBodyweightExercise.getPersonId().longValue());
        assertSame(ofResult2, toLocalDateResult);
        assertSame(ofResult, toLocalDateResult2);
        assertSame(actualBodyweightExercise.endTime, endTime);
        assertSame(actualBodyweightExercise.startTime, startTime2);
    }
}
