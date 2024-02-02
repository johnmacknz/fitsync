package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class NoDistanceCardioExerciseTest {
    /**
     * Method under test:
     * {@link NoDistanceCardioExercise#NoDistanceCardioExercise()}
     */
    @Test
    void testConstructor() {
        NoDistanceCardioExercise actualNoDistanceCardioExercise = new NoDistanceCardioExercise();
        assertNull(actualNoDistanceCardioExercise.getCaloriesBurned());
        assertNull(actualNoDistanceCardioExercise.getId());
        assertNull(actualNoDistanceCardioExercise.getPersonId());
        assertNull(actualNoDistanceCardioExercise.getDescription());
        assertNull(actualNoDistanceCardioExercise.getEquipmentRequired());
        assertNull(actualNoDistanceCardioExercise.getExerciseName());
        assertNull(actualNoDistanceCardioExercise.getEndTime());
        assertNull(actualNoDistanceCardioExercise.getStartTime());
        assertEquals(0L, actualNoDistanceCardioExercise.getDuration().toNanos());
    }

    /**
     * Method under test:
     * {@link NoDistanceCardioExercise#NoDistanceCardioExercise(Long, String, LocalDateTime, LocalDateTime, Integer)}
     */
    @Test
    void testConstructor2() {
        LocalDate ofResult = LocalDate.of(1970, 1, 1);
        LocalDateTime startTime = ofResult.atStartOfDay();
        LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
        NoDistanceCardioExercise actualNoDistanceCardioExercise = new NoDistanceCardioExercise(1L, "Exercise Name",
                startTime, ofResult2.atStartOfDay(), 1);

        LocalDateTime endTime = actualNoDistanceCardioExercise.getEndTime();
        assertEquals("00:00", endTime.toLocalTime().toString());
        LocalDateTime startTime2 = actualNoDistanceCardioExercise.getStartTime();
        assertEquals("00:00", startTime2.toLocalTime().toString());
        LocalDate toLocalDateResult = endTime.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult.toString());
        LocalDate toLocalDateResult2 = startTime2.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult2.toString());
        assertEquals("Exercise Name", actualNoDistanceCardioExercise.getExerciseName());
        assertNull(actualNoDistanceCardioExercise.getId());
        assertNull(actualNoDistanceCardioExercise.getDescription());
        assertNull(actualNoDistanceCardioExercise.getEquipmentRequired());
        assertEquals(0L, actualNoDistanceCardioExercise.getDuration().toNanos());
        assertEquals(1, actualNoDistanceCardioExercise.getCaloriesBurned().intValue());
        assertEquals(1L, actualNoDistanceCardioExercise.getPersonId().longValue());
        assertSame(ofResult2, toLocalDateResult);
        assertSame(ofResult, toLocalDateResult2);
        assertSame(actualNoDistanceCardioExercise.endTime, endTime);
        assertSame(actualNoDistanceCardioExercise.startTime, startTime2);
    }
}
