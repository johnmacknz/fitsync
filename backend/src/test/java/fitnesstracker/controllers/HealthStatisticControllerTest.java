package fitnesstracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitnesstracker.config.TestUtilities;
import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.services.HealthStatisticService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthStatisticController.class)
@AutoConfigureMockMvc
class HealthStatisticControllerTest {

    @MockBean
    HealthStatisticService mockHealthStatisticService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void getAllHealthStatistics() throws Exception {
        List<HealthStatistic> healthStatistics = TestUtilities.getStatsList();
        String expectedJson = mapper.writeValueAsString(healthStatistics);

        when(mockHealthStatisticService.getAllHealthStatistics()).thenReturn(healthStatistics);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stats");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedJson))
                .andReturn();

        verify(mockHealthStatisticService, times(1)).getAllHealthStatistics();
    }

    @Test
    void getHealthStatisticById() throws Exception {
        long healthStatisticId = 1;

        HealthStatistic healthStatistic = new HealthStatistic();
        when(mockHealthStatisticService.getHealthStatisticById(healthStatisticId)).thenReturn(healthStatistic);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stats/" + healthStatisticId);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        verify(mockHealthStatisticService, times(1)).getHealthStatisticById(healthStatisticId);
    }

    @Test
    void createHealthStatistic() throws Exception {
        HealthStatistic testHealthStatistic = new HealthStatistic();
        when(mockHealthStatisticService.existsByPersonId(1L)).thenReturn(Boolean.TRUE);
        testHealthStatistic.setPersonId(1L);  // Set a valid personId
        String json = mapper.writeValueAsString(testHealthStatistic);
        mockMvc.perform(MockMvcRequestBuilders.post("/stats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        verify(mockHealthStatisticService, times(1)).createHealthStatistic(any(HealthStatistic.class));
    }

    @Test
    void deleteHealthStatistic() throws Exception {
        long healthStatisticId = 1;
        HealthStatistic testHealthStatistic = new HealthStatistic();
        String json = mapper.writeValueAsString(testHealthStatistic);
        when(mockHealthStatisticService.getHealthStatisticById(healthStatisticId)).thenReturn(testHealthStatistic);
        mockMvc.perform(MockMvcRequestBuilders.delete("/stats/" + healthStatisticId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        verify(mockHealthStatisticService, times(1)).deleteHealthStatistic(any());
    }

    @Test
    void getHealthStatisticByInvalidId() throws Exception {
        long healthStatisticId = 99999;

        HealthStatistic healthStatistic = new HealthStatistic();
        when(mockHealthStatisticService.getHealthStatisticById(healthStatisticId)).thenThrow(EntityNotFoundException.class);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stats/" + healthStatisticId);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andReturn();

        verify(mockHealthStatisticService, times(1)).getHealthStatisticById(healthStatisticId);
    }
}