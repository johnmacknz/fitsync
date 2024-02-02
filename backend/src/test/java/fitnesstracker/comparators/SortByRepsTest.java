package fitnesstracker.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fitnesstracker.entities.exercise.StrengthTrainingExercise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SortByReps.class})
@ExtendWith(SpringExtension.class)
class SortByRepsTest {
    @Autowired
    private SortByReps sortByReps;

    /**
     * Method under test:
     * {@link SortByReps#compare(StrengthTrainingExercise, StrengthTrainingExercise)}
     */
    @Test
    void testCompare() {
        StrengthTrainingExercise a = new StrengthTrainingExercise();
        assertEquals(0, sortByReps.compare(a, new StrengthTrainingExercise()));
    }
}
