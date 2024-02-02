package fitnesstracker.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fitnesstracker.entities.exercise.StrengthTrainingExercise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SortBySets.class})
@ExtendWith(SpringExtension.class)
class SortBySetsTest {
    @Autowired
    private SortBySets sortBySets;

    /**
     * Method under test:
     * {@link SortBySets#compare(StrengthTrainingExercise, StrengthTrainingExercise)}
     */
    @Test
    void testCompare() {
        StrengthTrainingExercise a = new StrengthTrainingExercise();
        assertEquals(0, sortBySets.compare(a, new StrengthTrainingExercise()));
    }
}
