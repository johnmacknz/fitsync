package fitnesstracker.comparators;

import fitnesstracker.entities.exercise.WeightLiftingExercise;

import java.util.Comparator;

import static java.lang.Math.signum;

public class SortByWeight implements Comparator<WeightLiftingExercise> {

    @Override
    public int compare(WeightLiftingExercise a, WeightLiftingExercise b) {
        return (int) signum(a.getWeightInKg() - b.getWeightInKg());
    }
}
