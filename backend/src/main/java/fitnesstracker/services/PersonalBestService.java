package fitnesstracker.services;

import com.google.common.collect.Iterables;
import fitnesstracker.comparators.*;
import fitnesstracker.entities.exercise.DistanceCardioExercise;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.StrengthTrainingExercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.repositories.ExerciseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonalBestService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public PersonalBestService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public <T extends Exercise> Exercise getPersonalBestByPersonIdAndExerciseNameIgnoreCase(
            Long personId, String exerciseName, Comparator<T> comparator, Class<T> typeToken) {
        try {
            List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            List<T> typedExercises = new ArrayList<>(exercises.size());
            for (Exercise exercise : exercises) {
                if (typeToken.isInstance(exercise)) {
                    typedExercises.add(typeToken.cast(exercise));
                }
            }
            typedExercises.sort(comparator);
            Collections.reverse(typedExercises);
            return typedExercises.isEmpty() ? null : typedExercises.get(0);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
    }


    public Exercise getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        return getPersonalBestByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName, new SortByDuration(), Exercise.class);
    }

    public Exercise getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        return getPersonalBestByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName, new SortByDistance(), DistanceCardioExercise.class);
    }

    public Exercise getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        return getPersonalBestByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName, new SortByWeight(), WeightLiftingExercise.class);
    }

    public Exercise getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        return getPersonalBestByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName, new SortByReps(), StrengthTrainingExercise.class);
    }

    public Exercise getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        return getPersonalBestByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName, new SortBySets(), StrengthTrainingExercise.class);
    }

    public List<Exercise> getPersonalBestDurationByPersonId(Long personId) {
        List<Exercise> exercisesById = exerciseRepository.findByPersonId(personId);
        Set<String> exerciseNames = new HashSet<>();
        for (Exercise exercise : exercisesById) {
            exerciseNames.add(exercise.getExerciseName().toLowerCase());
        }
        List<Exercise> bestDurationExercises = new ArrayList<>();
        for (String exerciseName : exerciseNames) {
            bestDurationExercises.add(getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        Iterables.removeIf(bestDurationExercises, Objects::isNull);
        return bestDurationExercises;
    }

    public List<Exercise> getPersonalBestDistanceByPersonId(Long personId) {
        Set<String> exerciseNames = getExerciseNames(personId);
        List<Exercise> bestDistanceExercises = new ArrayList<>();
        for (String exerciseName : exerciseNames) {
            bestDistanceExercises.add(getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        Iterables.removeIf(bestDistanceExercises, Objects::isNull);
        return bestDistanceExercises;
    }

    @NotNull
    private Set<String> getExerciseNames(Long personId) {
        List<Exercise> exercisesById = exerciseRepository.findByPersonId(personId);
        Set<String> exerciseNames = new HashSet<>();
        for (Exercise exercise : exercisesById) {
            exerciseNames.add(exercise.getExerciseName().toLowerCase());
        }
        return exerciseNames;
    }

    public List<Exercise> getPersonalBestWeightByPersonId(Long personId) {
        List<Exercise> bestWeightExercises = new ArrayList<>();
        for (String exerciseName : getExerciseNames(personId)) {
            bestWeightExercises.add(getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        Iterables.removeIf(bestWeightExercises, Objects::isNull);
        return bestWeightExercises;
    }

    public List<Exercise> getPersonalBestRepsByPersonId(Long personId) {
        List<Exercise> bestRepsExercises = new ArrayList<>();
        for (String exerciseName : getExerciseNames(personId)) {
            bestRepsExercises.add(getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        Iterables.removeIf(bestRepsExercises, Objects::isNull);
        return bestRepsExercises;
    }

    public List<Exercise> getPersonalBestSetsByPersonId(Long personId) {
        List<Exercise> bestSetsExercises = new ArrayList<>();
        for (String exerciseName : getExerciseNames(personId)) {
            bestSetsExercises.add(getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        Iterables.removeIf(bestSetsExercises, Objects::isNull);
        return bestSetsExercises;
    }

    public List<Exercise> listifyIfNotNull(Exercise exercise) {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise);
        Iterables.removeIf(exercises, Objects::isNull);
        return exercises;
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
}
