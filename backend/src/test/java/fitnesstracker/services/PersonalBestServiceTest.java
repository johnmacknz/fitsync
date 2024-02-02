package fitnesstracker.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import fitnesstracker.entities.exercise.BodyweightExercise;
import fitnesstracker.entities.exercise.DistanceCardioExercise;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.repositories.ExerciseRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonalBestService.class})
@ExtendWith(SpringExtension.class)
class PersonalBestServiceTest {
    @MockBean
    private ExerciseRepository exerciseRepository;

    @Autowired
    private PersonalBestService personalBestService;

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        Exercise actualPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertSame(exercise, actualPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase3() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        Exercise actualPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        Exercise actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase3() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        Exercise actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase4() {
        DistanceCardioExercise distanceCardioExercise = new DistanceCardioExercise();
        distanceCardioExercise.setCaloriesBurned(1);
        distanceCardioExercise.setDescription("The characteristics of someone or something");
        distanceCardioExercise.setDistanceInKm(10.0d);
        distanceCardioExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        distanceCardioExercise.setEquipmentRequired("Equipment Required");
        distanceCardioExercise.setExerciseName("Exercise Name");
        distanceCardioExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        distanceCardioExercise.setCaloriesBurned(1);
        distanceCardioExercise.setDescription("The characteristics of someone or something");
        distanceCardioExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        distanceCardioExercise.setEquipmentRequired("Equipment Required");
        distanceCardioExercise.setExerciseName("Exercise Name");
        distanceCardioExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(distanceCardioExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertSame(distanceCardioExercise, actualPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        Exercise actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase3() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        Exercise actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase4() {
        WeightLiftingExercise weightLiftingExercise = new WeightLiftingExercise();
        weightLiftingExercise.setCaloriesBurned(1);
        weightLiftingExercise.setDescription("The characteristics of someone or something");
        weightLiftingExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        weightLiftingExercise.setEquipmentRequired("Equipment Required");
        weightLiftingExercise.setExerciseName("Exercise Name");
        weightLiftingExercise.setReps(1);
        weightLiftingExercise.setSets(1);
        weightLiftingExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        weightLiftingExercise.setTargetMuscle("Target Muscle");
        weightLiftingExercise.setWeightInKg(10.0d);
        weightLiftingExercise.setCaloriesBurned(1);
        weightLiftingExercise.setDescription("The characteristics of someone or something");
        weightLiftingExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        weightLiftingExercise.setEquipmentRequired("Equipment Required");
        weightLiftingExercise.setExerciseName("Exercise Name");
        weightLiftingExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(weightLiftingExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertSame(weightLiftingExercise, actualPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        Exercise actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase3() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        Exercise actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase4() {
        BodyweightExercise bodyweightExercise = new BodyweightExercise();
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setReps(1);
        bodyweightExercise.setSets(1);
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setTargetMuscle("Target Muscle");
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(bodyweightExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertSame(bodyweightExercise, actualPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        Exercise actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase3() {
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        Exercise actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertNull(actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(Long, String)}
     */
    @Test
    void testGetPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase4() {
        BodyweightExercise bodyweightExercise = new BodyweightExercise();
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setReps(1);
        bodyweightExercise.setSets(1);
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setTargetMuscle("Target Muscle");
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(bodyweightExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList);
        Exercise actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase = personalBestService
                .getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(1L, "Exercise Name");
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertSame(bodyweightExercise, actualPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase);
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestDurationByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDurationByPersonId() {
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        List<Exercise> actualPersonalBestDurationByPersonId = personalBestService.getPersonalBestDurationByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        assertTrue(actualPersonalBestDurationByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDurationByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDurationByPersonId2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDurationByPersonId = personalBestService.getPersonalBestDurationByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestDurationByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDurationByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDurationByPersonId3() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(1);
        exercise2.setDescription("The characteristics of someone or something");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("Equipment Required");
        exercise2.setExerciseName("Exercise Name");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(exercise2);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDurationByPersonId = personalBestService.getPersonalBestDurationByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertEquals(1, actualPersonalBestDurationByPersonId.size());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDurationByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDurationByPersonId4() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(0);
        exercise2.setDescription("Description");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("42");
        exercise2.setExerciseName("42");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise2);
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDurationByPersonId = personalBestService.getPersonalBestDurationByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository, atLeast(1)).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestDurationByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDurationByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDurationByPersonId5() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDurationByPersonId = personalBestService.getPersonalBestDurationByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestDurationByPersonId.isEmpty());
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestDistanceByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonId() {
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        List<Exercise> actualPersonalBestDistanceByPersonId = personalBestService.getPersonalBestDistanceByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        assertTrue(actualPersonalBestDistanceByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDistanceByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonId2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDistanceByPersonId = personalBestService.getPersonalBestDistanceByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestDistanceByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDistanceByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonId3() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(1);
        exercise2.setDescription("The characteristics of someone or something");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("Equipment Required");
        exercise2.setExerciseName("Exercise Name");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(exercise2);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDistanceByPersonId = personalBestService.getPersonalBestDistanceByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestDistanceByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDistanceByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonId4() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(0);
        exercise2.setDescription("Description");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("42");
        exercise2.setExerciseName("42");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise2);
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDistanceByPersonId = personalBestService.getPersonalBestDistanceByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository, atLeast(1)).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestDistanceByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDistanceByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonId5() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDistanceByPersonId = personalBestService.getPersonalBestDistanceByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestDistanceByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestDistanceByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestDistanceByPersonId6() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        DistanceCardioExercise distanceCardioExercise = new DistanceCardioExercise();
        distanceCardioExercise.setCaloriesBurned(1);
        distanceCardioExercise.setDescription("The characteristics of someone or something");
        distanceCardioExercise.setDistanceInKm(10.0d);
        distanceCardioExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        distanceCardioExercise.setEquipmentRequired("Equipment Required");
        distanceCardioExercise.setExerciseName("Exercise Name");
        distanceCardioExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        distanceCardioExercise.setCaloriesBurned(1);
        distanceCardioExercise.setDescription("The characteristics of someone or something");
        distanceCardioExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        distanceCardioExercise.setEquipmentRequired("Equipment Required");
        distanceCardioExercise.setExerciseName("Exercise Name");
        distanceCardioExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(distanceCardioExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestDistanceByPersonId = personalBestService.getPersonalBestDistanceByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertEquals(1, actualPersonalBestDistanceByPersonId.size());
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestWeightByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestWeightByPersonId() {
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        List<Exercise> actualPersonalBestWeightByPersonId = personalBestService.getPersonalBestWeightByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        assertTrue(actualPersonalBestWeightByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestWeightByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestWeightByPersonId2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestWeightByPersonId = personalBestService.getPersonalBestWeightByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestWeightByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestWeightByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestWeightByPersonId3() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(1);
        exercise2.setDescription("The characteristics of someone or something");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("Equipment Required");
        exercise2.setExerciseName("Exercise Name");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(exercise2);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestWeightByPersonId = personalBestService.getPersonalBestWeightByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestWeightByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestWeightByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestWeightByPersonId4() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(0);
        exercise2.setDescription("Description");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("42");
        exercise2.setExerciseName("42");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise2);
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestWeightByPersonId = personalBestService.getPersonalBestWeightByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository, atLeast(1)).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestWeightByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestWeightByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestWeightByPersonId5() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestWeightByPersonId = personalBestService.getPersonalBestWeightByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestWeightByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestWeightByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestWeightByPersonId6() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        WeightLiftingExercise weightLiftingExercise = new WeightLiftingExercise();
        weightLiftingExercise.setCaloriesBurned(1);
        weightLiftingExercise.setDescription("The characteristics of someone or something");
        weightLiftingExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        weightLiftingExercise.setEquipmentRequired("Equipment Required");
        weightLiftingExercise.setExerciseName("Exercise Name");
        weightLiftingExercise.setReps(1);
        weightLiftingExercise.setSets(1);
        weightLiftingExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        weightLiftingExercise.setTargetMuscle("Target Muscle");
        weightLiftingExercise.setWeightInKg(10.0d);
        weightLiftingExercise.setCaloriesBurned(1);
        weightLiftingExercise.setDescription("The characteristics of someone or something");
        weightLiftingExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        weightLiftingExercise.setEquipmentRequired("Equipment Required");
        weightLiftingExercise.setExerciseName("Exercise Name");
        weightLiftingExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(weightLiftingExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestWeightByPersonId = personalBestService.getPersonalBestWeightByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertEquals(1, actualPersonalBestWeightByPersonId.size());
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestRepsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestRepsByPersonId() {
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        List<Exercise> actualPersonalBestRepsByPersonId = personalBestService.getPersonalBestRepsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        assertTrue(actualPersonalBestRepsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestRepsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestRepsByPersonId2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestRepsByPersonId = personalBestService.getPersonalBestRepsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestRepsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestRepsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestRepsByPersonId3() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(1);
        exercise2.setDescription("The characteristics of someone or something");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("Equipment Required");
        exercise2.setExerciseName("Exercise Name");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(exercise2);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestRepsByPersonId = personalBestService.getPersonalBestRepsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestRepsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestRepsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestRepsByPersonId4() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(0);
        exercise2.setDescription("Description");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("42");
        exercise2.setExerciseName("42");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise2);
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestRepsByPersonId = personalBestService.getPersonalBestRepsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository, atLeast(1)).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestRepsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestRepsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestRepsByPersonId5() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestRepsByPersonId = personalBestService.getPersonalBestRepsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestRepsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestRepsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestRepsByPersonId6() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        BodyweightExercise bodyweightExercise = new BodyweightExercise();
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setReps(1);
        bodyweightExercise.setSets(1);
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setTargetMuscle("Target Muscle");
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(bodyweightExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestRepsByPersonId = personalBestService.getPersonalBestRepsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertEquals(1, actualPersonalBestRepsByPersonId.size());
    }

    /**
     * Method under test:  {@link PersonalBestService#getPersonalBestSetsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestSetsByPersonId() {
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        List<Exercise> actualPersonalBestSetsByPersonId = personalBestService.getPersonalBestSetsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        assertTrue(actualPersonalBestSetsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestSetsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestSetsByPersonId2() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestSetsByPersonId = personalBestService.getPersonalBestSetsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestSetsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestSetsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestSetsByPersonId3() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(1);
        exercise2.setDescription("The characteristics of someone or something");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("Equipment Required");
        exercise2.setExerciseName("Exercise Name");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(exercise2);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestSetsByPersonId = personalBestService.getPersonalBestSetsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestSetsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestSetsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestSetsByPersonId4() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(0);
        exercise2.setDescription("Description");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("42");
        exercise2.setExerciseName("42");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise2);
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestSetsByPersonId = personalBestService.getPersonalBestSetsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository, atLeast(1)).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestSetsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestSetsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestSetsByPersonId5() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new IndexOutOfBoundsException("foo"));
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestSetsByPersonId = personalBestService.getPersonalBestSetsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertTrue(actualPersonalBestSetsByPersonId.isEmpty());
    }

    /**
     * Method under test:
     * {@link PersonalBestService#getPersonalBestSetsByPersonId(Long)}
     */
    @Test
    void testGetPersonalBestSetsByPersonId6() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);

        BodyweightExercise bodyweightExercise = new BodyweightExercise();
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setReps(1);
        bodyweightExercise.setSets(1);
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setTargetMuscle("Target Muscle");
        bodyweightExercise.setCaloriesBurned(1);
        bodyweightExercise.setDescription("The characteristics of someone or something");
        bodyweightExercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        bodyweightExercise.setEquipmentRequired("Equipment Required");
        bodyweightExercise.setExerciseName("Exercise Name");
        bodyweightExercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());

        ArrayList<Exercise> exerciseList2 = new ArrayList<>();
        exerciseList2.add(bodyweightExercise);
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(exerciseList2);
        when(exerciseRepository.findByPersonId(Mockito.<Long>any())).thenReturn(exerciseList);
        List<Exercise> actualPersonalBestSetsByPersonId = personalBestService.getPersonalBestSetsByPersonId(1L);
        verify(exerciseRepository).findByPersonId(Mockito.<Long>any());
        verify(exerciseRepository).findExerciseByPersonIdAndExerciseNameIgnoreCase(Mockito.<Long>any(),
                Mockito.<String>any());
        assertEquals(1, actualPersonalBestSetsByPersonId.size());
    }

    /**
     * Method under test: {@link PersonalBestService#listifyIfNotNull(Exercise)}
     */
    @Test
    void testListifyIfNotNull() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertEquals(1, personalBestService.listifyIfNotNull(exercise).size());
    }

    /**
     * Method under test: {@link PersonalBestService#saveExercise(Exercise)}
     */
    @Test
    void testSaveExercise() {
        Exercise exercise = new Exercise();
        exercise.setCaloriesBurned(1);
        exercise.setDescription("The characteristics of someone or something");
        exercise.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise.setEquipmentRequired("Equipment Required");
        exercise.setExerciseName("Exercise Name");
        exercise.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(exerciseRepository.save(Mockito.<Exercise>any())).thenReturn(exercise);

        Exercise exercise2 = new Exercise();
        exercise2.setCaloriesBurned(1);
        exercise2.setDescription("The characteristics of someone or something");
        exercise2.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        exercise2.setEquipmentRequired("Equipment Required");
        exercise2.setExerciseName("Exercise Name");
        exercise2.setStartTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        Exercise actualSaveExerciseResult = personalBestService.saveExercise(exercise2);
        verify(exerciseRepository).save(Mockito.<Exercise>any());
        assertSame(exercise, actualSaveExerciseResult);
    }
}
