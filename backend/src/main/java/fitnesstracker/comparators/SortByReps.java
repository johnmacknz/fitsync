package fitnesstracker.comparators;

import fitnesstracker.entities.exercise.StrengthTrainingExercise;

import java.util.Comparator;

public class SortByReps implements Comparator<StrengthTrainingExercise> {
    @Override
    public int compare(StrengthTrainingExercise a, StrengthTrainingExercise b) {
        return a.getReps()-b.getReps();
    }
}
