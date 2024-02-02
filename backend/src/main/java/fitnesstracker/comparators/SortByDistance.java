package fitnesstracker.comparators;

import fitnesstracker.entities.exercise.DistanceCardioExercise;

import java.util.Comparator;

import static java.lang.Math.signum;

public class SortByDistance implements Comparator<DistanceCardioExercise> {

    @Override
    public int compare(DistanceCardioExercise a, DistanceCardioExercise b) {
        return (int) signum(a.getDistanceInKm()-b.getDistanceInKm());
    }
}
