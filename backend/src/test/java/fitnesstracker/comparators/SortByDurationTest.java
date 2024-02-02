package fitnesstracker.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fitnesstracker.entities.exercise.Exercise;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SortByDuration.class})
@ExtendWith(SpringExtension.class)
class SortByDurationTest {
    @Autowired
    private SortByDuration sortByDuration;

    /**
     * Method under test: {@link SortByDuration#compare(Exercise, Exercise)}
     */
    @Test
    void testCompare() {
        Exercise a = new Exercise();
        a.setCaloriesBurned(1);
        a.setDescription("The characteristics of someone or something");
        a.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        a.setEquipmentRequired("Equipment Required");
        a.setExerciseName("Exercise Name");
        a.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        Exercise b = new Exercise();
        b.setCaloriesBurned(1);
        b.setDescription("The characteristics of someone or something");
        b.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        b.setEquipmentRequired("Equipment Required");
        b.setExerciseName("Exercise Name");
        b.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertEquals(0, sortByDuration.compare(a, b));
    }
}
