package fitnesstracker.entities.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Exercise.class})
@ExtendWith(SpringExtension.class)
class ExerciseTest {
    @Autowired
    private Exercise exercise;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Exercise#Exercise()}
     *   <li>{@link Exercise#setCaloriesBurned(Integer)}
     *   <li>{@link Exercise#setDescription(String)}
     *   <li>{@link Exercise#setEndExclusive(LocalDateTime)}
     *   <li>{@link Exercise#setEndTime(LocalDateTime)}
     *   <li>{@link Exercise#setEquipmentRequired(String)}
     *   <li>{@link Exercise#setExerciseName(String)}
     *   <li>{@link Exercise#setStartInclusive(LocalDateTime)}
     *   <li>{@link Exercise#setStartTime(LocalDateTime)}
     *   <li>{@link Exercise#getCaloriesBurned()}
     *   <li>{@link Exercise#getDescription()}
     *   <li>{@link Exercise#getEndTime()}
     *   <li>{@link Exercise#getEquipmentRequired()}
     *   <li>{@link Exercise#getExerciseName()}
     *   <li>{@link Exercise#getId()}
     *   <li>{@link Exercise#getPersonId()}
     *   <li>{@link Exercise#getStartTime()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Exercise actualExercise = new Exercise();
        actualExercise.setCaloriesBurned(1);
        actualExercise.setDescription("The characteristics of someone or something");
        actualExercise.setEndExclusive(LocalDate.of(1970, 1, 1).atStartOfDay());
        LocalDateTime endTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualExercise.setEndTime(endTime);
        actualExercise.setEquipmentRequired("Equipment Required");
        actualExercise.setExerciseName("Exercise Name");
        actualExercise.setStartInclusive(LocalDate.of(1970, 1, 1).atStartOfDay());
        LocalDateTime startTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualExercise.setStartTime(startTime);
        Integer actualCaloriesBurned = actualExercise.getCaloriesBurned();
        String actualDescription = actualExercise.getDescription();
        LocalDateTime actualEndTime = actualExercise.getEndTime();
        String actualEquipmentRequired = actualExercise.getEquipmentRequired();
        String actualExerciseName = actualExercise.getExerciseName();
        actualExercise.getId();
        actualExercise.getPersonId();
        LocalDateTime actualStartTime = actualExercise.getStartTime();
        assertEquals("Equipment Required", actualEquipmentRequired);
        assertEquals("Exercise Name", actualExerciseName);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1, actualCaloriesBurned.intValue());
        assertSame(endTime, actualEndTime);
        assertSame(startTime, actualStartTime);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link Exercise#Exercise(Long, String, LocalDateTime, LocalDateTime, Integer)}
     *   <li>{@link Exercise#setCaloriesBurned(Integer)}
     *   <li>{@link Exercise#setDescription(String)}
     *   <li>{@link Exercise#setEndExclusive(LocalDateTime)}
     *   <li>{@link Exercise#setEndTime(LocalDateTime)}
     *   <li>{@link Exercise#setEquipmentRequired(String)}
     *   <li>{@link Exercise#setExerciseName(String)}
     *   <li>{@link Exercise#setStartInclusive(LocalDateTime)}
     *   <li>{@link Exercise#setStartTime(LocalDateTime)}
     *   <li>{@link Exercise#getCaloriesBurned()}
     *   <li>{@link Exercise#getDescription()}
     *   <li>{@link Exercise#getEndTime()}
     *   <li>{@link Exercise#getEquipmentRequired()}
     *   <li>{@link Exercise#getExerciseName()}
     *   <li>{@link Exercise#getId()}
     *   <li>{@link Exercise#getPersonId()}
     *   <li>{@link Exercise#getStartTime()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime startTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        Exercise actualExercise = new Exercise(1L, "Exercise Name", startTime, LocalDate.of(1970, 1, 1).atStartOfDay(), 1);
        actualExercise.setCaloriesBurned(1);
        actualExercise.setDescription("The characteristics of someone or something");
        actualExercise.setEndExclusive(LocalDate.of(1970, 1, 1).atStartOfDay());
        LocalDateTime endTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualExercise.setEndTime(endTime);
        actualExercise.setEquipmentRequired("Equipment Required");
        actualExercise.setExerciseName("Exercise Name");
        actualExercise.setStartInclusive(LocalDate.of(1970, 1, 1).atStartOfDay());
        LocalDateTime startTime2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualExercise.setStartTime(startTime2);
        Integer actualCaloriesBurned = actualExercise.getCaloriesBurned();
        String actualDescription = actualExercise.getDescription();
        LocalDateTime actualEndTime = actualExercise.getEndTime();
        String actualEquipmentRequired = actualExercise.getEquipmentRequired();
        String actualExerciseName = actualExercise.getExerciseName();
        actualExercise.getId();
        Long actualPersonId = actualExercise.getPersonId();
        LocalDateTime actualStartTime = actualExercise.getStartTime();
        assertEquals("Equipment Required", actualEquipmentRequired);
        assertEquals("Exercise Name", actualExerciseName);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1, actualCaloriesBurned.intValue());
        assertEquals(1L, actualPersonId.longValue());
        assertSame(endTime, actualEndTime);
        assertSame(startTime2, actualStartTime);
    }

    /**
     * Method under test: {@link Exercise#getDuration()}
     */
    @Test
    void testGetDuration() {
        Duration actualDuration = (new Exercise()).getDuration();
        assertEquals(0L, actualDuration.toNanos());
        assertSame(actualDuration.ZERO, actualDuration);
    }

    /**
     * Method under test: {@link Exercise#getDuration()}
     */
    @Test
    void testGetDuration2() {
        BodyweightExercise bodyweightExercise = new BodyweightExercise();
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndExclusive(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setReps(1);
        bodyweightExercise.setSets(1);
        bodyweightExercise.setStartInclusive(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setTargetMuscle("Target Muscle");
        Duration actualDuration = bodyweightExercise.getDuration();
        assertEquals(0L, actualDuration.toNanos());
        assertSame(actualDuration.ZERO, actualDuration);
    }

    /**
     * Method under test: {@link Exercise#getDuration()}
     */
    @Test
    void testGetDuration3() {
        Exercise exercise2 = new Exercise();
        exercise2.setStartInclusive(LocalDate.of(1970, 1, 1).atStartOfDay());
        Duration actualDuration = exercise2.getDuration();
        assertEquals(0L, actualDuration.toNanos());
        assertSame(actualDuration.ZERO, actualDuration);
    }

    /**
     * Method under test: {@link Exercise#tokenizeExerciseName()}
     */
    @Test
    void testTokenizeExerciseName() {
        Exercise exercise2 = new Exercise();
        exercise2.setExerciseName("Exercise Name");
        assertEquals("exercise_name", exercise2.tokenizeExerciseName());
    }
}
