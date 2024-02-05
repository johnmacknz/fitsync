package fitnesstracker.data;

import fitnesstracker.entities.exercise.*;

public class ExerciseUtils {
    public static Exercise convertExercise(Exercise exercise) {
        switch (exercise.getExerciseType()) {
            case "BodyWeight Exercise":
                return new BodyweightExercise(exercise.getPersonId(), exercise.getExerciseName(), exercise.getStartTime(), exercise.getEndTime(), exercise.getCaloriesBurned(), exercise.getSets(), exercise.getReps(), exercise.getTargetMuscle());
            case "WeightLifting Exercise":
                return new WeightLiftingExercise(exercise.getPersonId(), exercise.getExerciseName(), exercise.getStartTime(), exercise.getEndTime(), exercise.getCaloriesBurned(), exercise.getSets(), exercise.getReps(), exercise.getWeightInKg(), exercise.getTargetMuscle());
            case "Isometric Exercise":
                return new IsometricExercise(exercise.getPersonId(), exercise.getExerciseName(), exercise.getStartTime(), exercise.getEndTime(), exercise.getCaloriesBurned(), exercise.getTargetMuscle());
            case "Distance Cardio Exercise":
                return new DistanceCardioExercise(exercise.getPersonId(), exercise.getExerciseName(), exercise.getStartTime(), exercise.getEndTime(), exercise.getCaloriesBurned(), exercise.getDistanceInKm());
            case "No Distance Cardio Exercise":
                return new NoDistanceCardioExercise(exercise.getPersonId(), exercise.getExerciseName(), exercise.getStartTime(), exercise.getEndTime(), exercise.getCaloriesBurned());
            default:
                return new Exercise();
        }
    }
}

