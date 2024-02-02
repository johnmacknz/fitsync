package fitnesstracker.comparators;

import fitnesstracker.entities.exercise.StrengthTrainingExercise;

import java.util.Comparator;

public class SortBySets implements Comparator<StrengthTrainingExercise> {
    @Override
    public int compare(StrengthTrainingExercise a, StrengthTrainingExercise b) {
        return a.getSets()-b.getSets();
    }
}
