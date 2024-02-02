package fitnesstracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.services.MealService;
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
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MealController.class)
@AutoConfigureMockMvc
class MealControllerTest {

    @MockBean
    MealService mockMealService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

//    @Test
//    void testGetAllMeals() throws Exception {
//        ArrayList<Meal> meals = TestUtilities.getMealList();
//        String expectedJson = mapper.writeValueAsString(meals);
//
//        when(mockMealService.findAll()).thenReturn(meals);
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/meals");
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().string(expectedJson))
//                .andReturn();
//
//        verify(mockMealService, times(1)).findAll();
//    }

    @Test
    void testGetMealById() throws Exception {
        long mealId = 1;

        Meal meal = new Meal();
        when(mockMealService.getMealById(mealId)).thenReturn(meal);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/meals/" + mealId);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        verify(mockMealService, times(1)).getMealById(mealId);
    }

    @Test
    void testAddingAMeal() throws Exception {

        Meal testMeal = new Meal();
        String json = mapper.writeValueAsString(testMeal);
        mockMvc.perform(MockMvcRequestBuilders.post("/meals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        verify(mockMealService, times(1)).saveMeal(any(Meal.class));
    }

    @Test
    void testGetAllMealsWithException() throws Exception {
        when(mockMealService.findAll()).thenThrow(new RuntimeException("Simulated service exception"));

        mockMvc.perform(MockMvcRequestBuilders.get("/meals"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(result -> {
                    ResponseStatusException exception = (ResponseStatusException) result.getResolvedException();
                    String expectedErrorMessage = "An error occurred while fetching meals";

                    assert exception != null;
                    String actualErrorMessage = exception.getMessage();
                    assertTrue(actualErrorMessage.contains(expectedErrorMessage));
                })
                .andDo(print());
    }

    @Test
    void testAddMealWithBadRequestException() throws Exception {
        Meal meal = new Meal();
        when(mockMealService.saveMeal(any())).thenThrow(new IllegalArgumentException("Invalid meal data"));

        mockMvc.perform(MockMvcRequestBuilders.post("/meals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(meal)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> {
                    ResponseStatusException exception = (ResponseStatusException) result.getResolvedException();
                    String expectedErrorMessage = "Invalid meal data";

                    assert exception != null;
                    String actualErrorMessage = exception.getMessage();

                    assertTrue(actualErrorMessage.contains(expectedErrorMessage));
                })
                .andDo(print());
    }

    @Test
    void testGetMealByIdWithNotFoundException() throws Exception {
        long nonExistingMealId = 123L;
        when(mockMealService.getMealById(nonExistingMealId)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/meals/{mealId}", nonExistingMealId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(result -> {
                    ResponseStatusException exception = (ResponseStatusException) result.getResolvedException();
                    String expectedErrorMessage = "Meal not found";

                    assert exception != null;
                    String actualErrorMessage = exception.getMessage();

                    assertTrue(actualErrorMessage.contains(expectedErrorMessage));
                })
                .andDo(print());
    }
}
