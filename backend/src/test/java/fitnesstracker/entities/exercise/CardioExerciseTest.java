package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CardioExerciseTest {
    /**
     * Method under test: {@link CardioExercise#CardioExercise()}
     */
    @Test
    void testConstructor() {
        CardioExercise actualCardioExercise = new CardioExercise();
        assertNull(actualCardioExercise.getCaloriesBurned());
        assertNull(actualCardioExercise.getId());
        assertNull(actualCardioExercise.getPersonId());
        assertNull(actualCardioExercise.getDescription());
        assertNull(actualCardioExercise.getEquipmentRequired());
        assertNull(actualCardioExercise.getExerciseName());
        assertNull(actualCardioExercise.getEndTime());
        assertNull(actualCardioExercise.getStartTime());
        assertEquals(0L, actualCardioExercise.getDuration().toNanos());
    }

    /**
     * Method under test:
     * {@link CardioExercise#CardioExercise(Long, String, LocalDateTime, LocalDateTime, Integer)}
     */
    @Test
    void testConstructor2() {
        LocalDate ofResult = LocalDate.of(1970, 1, 1);
        LocalDateTime startTime = ofResult.atStartOfDay();
        LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
        CardioExercise actualCardioExercise = new CardioExercise(1L, "Exercise Name", startTime, ofResult2.atStartOfDay(),
                1);

        LocalDateTime endTime = actualCardioExercise.getEndTime();
        assertEquals("00:00", endTime.toLocalTime().toString());
        LocalDateTime startTime2 = actualCardioExercise.getStartTime();
        assertEquals("00:00", startTime2.toLocalTime().toString());
        LocalDate toLocalDateResult = endTime.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult.toString());
        LocalDate toLocalDateResult2 = startTime2.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult2.toString());
        assertEquals("Exercise Name", actualCardioExercise.getExerciseName());
        assertNull(actualCardioExercise.getId());
        assertNull(actualCardioExercise.getDescription());
        assertNull(actualCardioExercise.getEquipmentRequired());
        assertEquals(0L, actualCardioExercise.getDuration().toNanos());
        assertEquals(1, actualCardioExercise.getCaloriesBurned().intValue());
        assertEquals(1L, actualCardioExercise.getPersonId().longValue());
        assertSame(ofResult2, toLocalDateResult);
        assertSame(ofResult, toLocalDateResult2);
        assertSame(actualCardioExercise.endTime, endTime);
        assertSame(actualCardioExercise.startTime, startTime2);
    }
}
