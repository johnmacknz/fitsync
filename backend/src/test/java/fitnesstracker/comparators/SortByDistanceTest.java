package fitnesstracker.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fitnesstracker.entities.exercise.DistanceCardioExercise;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SortByDistance.class})
@ExtendWith(SpringExtension.class)
class SortByDistanceTest {
    @Autowired
    private SortByDistance sortByDistance;

    /**
     * Method under test:
     * {@link SortByDistance#compare(DistanceCardioExercise, DistanceCardioExercise)}
     */
    @Test
    void testCompare() {
        DistanceCardioExercise a = new DistanceCardioExercise();
        a.setCaloriesBurned(1);
        a.setDescription("The characteristics of someone or something");
        a.setDistanceInKm(10.0d);
        a.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        a.setEquipmentRequired("Equipment Required");
        a.setExerciseName("Exercise Name");
        a.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        DistanceCardioExercise b = new DistanceCardioExercise();
        b.setCaloriesBurned(1);
        b.setDescription("The characteristics of someone or something");
        b.setDistanceInKm(10.0d);
        b.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        b.setEquipmentRequired("Equipment Required");
        b.setExerciseName("Exercise Name");
        b.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertEquals(0, sortByDistance.compare(a, b));
    }
}
