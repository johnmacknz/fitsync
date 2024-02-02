package fitnesstracker.comparators;

import fitnesstracker.entities.exercise.Exercise;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class SortByDuration implements Comparator<Exercise> {

    @Override
    public int compare(@NotNull Exercise a, @NotNull Exercise b) {
        return a.getDuration().compareTo(b.getDuration());
    }
}
