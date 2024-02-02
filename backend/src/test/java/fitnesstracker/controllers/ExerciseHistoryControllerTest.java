package fitnesstracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitnesstracker.config.TestUtilities;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.ExerciseHistoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExerciseHistoryController.class)
@AutoConfigureMockMvc
class ExerciseHistoryControllerTest {

    @MockBean
    private ExerciseHistoryService mockExerciseHistoryService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ExerciseHistoryController exerciseController;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testGetAllExercises() throws Exception {
        List<Exercise> exercises = TestUtilities.getExerciseList();
        String expectedJson = mapper.writeValueAsString(exercises);

        when(mockExerciseHistoryService.findAll()).thenReturn(exercises);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercises");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedJson))
                .andReturn();

        verify(mockExerciseHistoryService, times(1)).findAll();
    }

    @Test
    void testGetExerciseById() throws Exception {
        long exerciseId = 1;

        Exercise exercise = new Exercise();
        when(mockExerciseHistoryService.getExerciseById(exerciseId)).thenReturn(exercise);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercises/exercise/{exerciseId}", exerciseId);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        verify(mockExerciseHistoryService, times(1)).getExerciseById(exerciseId);
    }

    @Test
    void testAddingAExercise() throws Exception {

        Exercise testExercise = new Exercise();
        String json = mapper.writeValueAsString(testExercise);

        mockMvc.perform(MockMvcRequestBuilders.post("/exercises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(mockExerciseHistoryService, times(1)).addExercise(any(Exercise.class));
    }





    @Test
    void testGetAllExercisesWithException() throws Exception {
        when(mockExerciseHistoryService.findAll()).thenThrow(new RuntimeException("Simulated service exception"));

        mockMvc.perform(MockMvcRequestBuilders.get("/exercises"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(result -> {
                    ResponseStatusException exception = (ResponseStatusException) result.getResolvedException();
                    String expectedErrorMessage = "An error occurred while fetching exercises";

                    assert exception != null;
                    String actualErrorMessage = exception.getMessage();
                    assertTrue(actualErrorMessage.contains(expectedErrorMessage));
                })
                .andDo(print());
    }

    @Test
    void testAddExerciseWithBadRequestException() throws Exception {
        Exercise exercise = new Exercise();
        when(mockExerciseHistoryService.addExercise(any())).thenThrow(new IllegalArgumentException("Invalid exercise data"));

        mockMvc.perform(MockMvcRequestBuilders.post("/exercises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(exercise)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> {
                    ResponseStatusException exception = (ResponseStatusException) result.getResolvedException();
                    String expectedErrorMessage = "Invalid exercise data";

                    assert exception != null;
                    String actualErrorMessage = exception.getMessage();

                    assertTrue(actualErrorMessage.contains(expectedErrorMessage));
                })
                .andDo(print());
    }

    @Test
    void testGetExerciseByIdWithNotFoundException() throws Exception {
        long nonExistingExerciseId = 123L;
        when(mockExerciseHistoryService.getExerciseById(nonExistingExerciseId)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/exercises/exercise/{exerciseId}", nonExistingExerciseId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(result -> {
                    ResponseStatusException exception = (ResponseStatusException) result.getResolvedException();
                    String expectedErrorMessage = "Exercise not found";

                    assert exception != null;
                    String actualErrorMessage = exception.getMessage();

                    assertTrue(actualErrorMessage.contains(expectedErrorMessage));
                })
                .andDo(print());
    }

    @Test
    void testDeleteExercise() throws Exception {
        long exerciseId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/exercises/exercise/{id}", exerciseId))
                .andExpect(status().isOk());

        verify(mockExerciseHistoryService, times(1)).deleteById(exerciseId);
    }

    @Test
    void testFindAllExercisesByPersonId() throws Exception {
        long personId = 1L;
        List<Exercise> exercises = TestUtilities.getExerciseList();
        String expectedJson = mapper.writeValueAsString(exercises);

        when(mockExerciseHistoryService.findByPersonId(personId)).thenReturn(exercises);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercises/person/{personId}", personId);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedJson))
                .andReturn();

        verify(mockExerciseHistoryService, times(1)).findByPersonId(personId);
    }

    @Test
    void testFindAllExercisesByPersonIdAndExerciseName() throws Exception {
        long personId = 1L;
        String exerciseName = "Running";
        List<Exercise> exercises = TestUtilities.getExerciseList();
        String expectedJson = mapper.writeValueAsString(exercises);

        when(mockExerciseHistoryService.findExerciseByPersonIdAndExerciseName(personId, exerciseName)).thenReturn(exercises);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercises/person/{personId}/{exerciseName}", personId, exerciseName);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedJson))
                .andReturn();

        verify(mockExerciseHistoryService, times(1)).findExerciseByPersonIdAndExerciseName(personId, exerciseName);
    }

    @Test
    void testGetExerciseByName() throws Exception {
        String exerciseName = "Running";
        List<Exercise> exercises = TestUtilities.getExerciseList();
        String expectedJson = mapper.writeValueAsString(exercises);

        when(mockExerciseHistoryService.getExerciseByName(exerciseName)).thenReturn(exercises);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercises/name/{exerciseName}", exerciseName);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedJson))
                .andReturn();

        verify(mockExerciseHistoryService, times(1)).getExerciseByName(exerciseName);
    }
}

