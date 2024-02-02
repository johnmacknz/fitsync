package fitnesstracker.services;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.exceptions.ExerciseServiceException;
import fitnesstracker.repositories.ExerciseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ExerciseHistoryServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseHistoryService exerciseHistoryService;

    @Test
    void repoIsEmpty_WhenRepoIsEmpty_ReturnsTrue() {
        when(exerciseRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(exerciseHistoryService.repoIsEmpty());

        verify(exerciseRepository, times(1)).findAll();
    }

    @Test
     void repoIsEmpty_WhenRepoIsNotEmpty_ReturnsFalse() {
        when(exerciseRepository.findAll()).thenReturn(Arrays.asList(new Exercise(), new Exercise()));

        assertFalse(exerciseHistoryService.repoIsEmpty());

        verify(exerciseRepository, times(1)).findAll();
    }

    @Test
    void getAllExercises_ReturnsExerciseList() {
        List<Exercise> exercises = Arrays.asList(new Exercise(), new Exercise());
        when(exerciseRepository.findAll()).thenReturn(exercises);

        List<Exercise> result = exerciseHistoryService.findAll();

        assertEquals(exercises, result);

        verify(exerciseRepository, times(1)).findAll();
    }

    @Test
    void getExerciseById_WithValidId_ReturnsExercise() {
        long exerciseId = 1L;
        Exercise exercise = new Exercise();
        when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.of(exercise));

        Exercise result = exerciseHistoryService.getExerciseById(exerciseId);

        assertEquals(exercise, result);

        verify(exerciseRepository, times(1)).findById(exerciseId);
    }

    @Test
    void getExerciseById_WithInvalidId_ReturnsNull() {
        long exerciseId = 1L;
        when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.empty());

        Exercise result = exerciseHistoryService.getExerciseById(exerciseId);

        assertNull(result);

        verify(exerciseRepository, times(1)).findById(exerciseId);
    }

    @Test
    void addExercise_ReturnsSavedExercise() {
        Exercise exerciseToSave = new Exercise();
        Exercise savedExercise = new Exercise();
        when(exerciseRepository.save(exerciseToSave)).thenReturn(savedExercise);

        Exercise result = exerciseHistoryService.addExercise(exerciseToSave);

        assertEquals(savedExercise, result);

        verify(exerciseRepository, times(1)).save(exerciseToSave);
    }

    @Test
    void deleteById_DeletesExercise() {
        long exerciseId = 1L;

        exerciseHistoryService.deleteById(exerciseId);

        verify(exerciseRepository, times(1)).deleteById(exerciseId);
    }

    @Test
    void testGetExerciseByName() {
        Long personId = 1L;
        String exerciseName = "Weightlifting";
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise(personId, "Weightlifting", LocalDateTime.of(2023, 11, 30, 10, 0), LocalDateTime.of(2023, 11, 30, 11, 0), 200));
        when(exerciseRepository.findExerciseByExerciseNameIgnoreCase(exerciseName)).thenReturn(exercises);

        ExerciseHistoryService exerciseHistoryService = new ExerciseHistoryService(exerciseRepository);
        List<Exercise> result = exerciseHistoryService.getExerciseByName(exerciseName);

        assertEquals(exercises, result);
    }

    @Test
    void testFindByPersonId() {
        Long personId = 1L;
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise(personId, "Weightlifting", LocalDateTime.of(2023, 11, 30, 10, 0), LocalDateTime.of(2023, 11, 30, 11, 0), 200));
        when(exerciseRepository.findByPersonId(personId)).thenReturn(exercises);

        ExerciseHistoryService exerciseHistoryService = new ExerciseHistoryService(exerciseRepository);
        List<Exercise> result = exerciseHistoryService.findByPersonId(personId);

        assertEquals(exercises, result);
    }

    @Test
    void testFindExerciseByPersonIdAndExerciseName() {
        Long personId = 1L;
        String exerciseName = "Weightlifting";
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise(personId, "Weightlifting", LocalDateTime.of(2023, 11, 30, 10, 0), LocalDateTime.of(2023, 11, 30, 11, 0), 200));
        when(exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName)).thenReturn(exercises);

        ExerciseHistoryService exerciseHistoryService = new ExerciseHistoryService(exerciseRepository);
        List<Exercise> result = exerciseHistoryService.findExerciseByPersonIdAndExerciseName(personId, exerciseName);

        assertEquals(exercises, result);
    }

    @Test
    void testFindAllWithException() {
        when(exerciseRepository.findAll()).thenThrow(new RuntimeException("Simulated database exception"));

        ExerciseServiceException exception = assertThrows(ExerciseServiceException.class, () -> exerciseHistoryService.findAll());
    }


}