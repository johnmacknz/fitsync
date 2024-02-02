package fitnesstracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitnesstracker.services.PersonalBestService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonalBestController.class)
@AutoConfigureMockMvc
class PersonalBestControllerTest {

    @MockBean
    private PersonalBestService mockPersonalBestService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private final Long personId = 1L;

    @ParameterizedTest
    @ValueSource(strings = {"weight", "duration", "distance", "sets", "reps"})
    void testGetPersonalBestsByMetric(String metric) throws Exception {

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercises/pb/{metric}/{personId}", metric, personId);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        switch (metric) {
            case "weight" -> verify(mockPersonalBestService, times(1)).getPersonalBestWeightByPersonId(personId);
            case "duration" -> verify(mockPersonalBestService, times(1)).getPersonalBestDurationByPersonId(personId);
            case "distance" -> verify(mockPersonalBestService, times(1)).getPersonalBestDistanceByPersonId(personId);
            case "sets" -> verify(mockPersonalBestService, times(1)).getPersonalBestSetsByPersonId(personId);
            case "reps" -> verify(mockPersonalBestService, times(1)).getPersonalBestRepsByPersonId(personId);
        }
    }

    @ParameterizedTest
    @CsvSource({"weight, bench press", "duration, plank", "distance, run", "sets, deadlifts", "reps, push ups"})
    void testGetPersonalBestsByMetricAndExerciseName(String metric, String exerciseName) throws Exception {

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercises/pb/{metric}/{personId}/{exerciseName}", metric, personId, exerciseName);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        switch (metric) {
            case "weight" -> verify(mockPersonalBestService, times(1)).getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            case "duration" -> verify(mockPersonalBestService, times(1)).getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            case "distance" -> verify(mockPersonalBestService, times(1)).getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            case "sets" -> verify(mockPersonalBestService, times(1)).getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            case "reps" -> verify(mockPersonalBestService, times(1)).getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        }
    }
}