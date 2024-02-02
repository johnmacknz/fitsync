package fitnesstracker.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fitnesstracker.entities.exercise.WeightLiftingExercise;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SortByWeight.class})
@ExtendWith(SpringExtension.class)
class SortByWeightTest {
    @Autowired
    private SortByWeight sortByWeight;

    /**
     * Method under test:
     * {@link SortByWeight#compare(WeightLiftingExercise, WeightLiftingExercise)}
     */
    @Test
    void testCompare() {
        WeightLiftingExercise a = new WeightLiftingExercise();
        a.setCaloriesBurned(1);
        a.setDescription("The characteristics of someone or something");
        a.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        a.setEquipmentRequired("Equipment Required");
        a.setExerciseName("Exercise Name");
        a.setReps(1);
        a.setSets(1);
        a.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        a.setTargetMuscle("Target Muscle");
        a.setWeightInKg(10.0d);

        WeightLiftingExercise b = new WeightLiftingExercise();
        b.setCaloriesBurned(1);
        b.setDescription("The characteristics of someone or something");
        b.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        b.setEquipmentRequired("Equipment Required");
        b.setExerciseName("Exercise Name");
        b.setReps(1);
        b.setSets(1);
        b.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        b.setTargetMuscle("Target Muscle");
        b.setWeightInKg(10.0d);
        assertEquals(0, sortByWeight.compare(a, b));
    }
}
