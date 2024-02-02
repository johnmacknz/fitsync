package fitnesstracker.services;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.exceptions.MealServiceException;
import fitnesstracker.repositories.MealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MealServiceTest {

    @MockBean
    private MealRepository mockMealRepository;

    @Autowired
    private MealService mealService;

    @Test
    void testFindAll() {
        List<Meal> mockMeals = Collections.singletonList(new Meal());
        when(mockMealRepository.findAll()).thenReturn(mockMeals);

        List<Meal> result = mealService.findAll();

        assertEquals(mockMeals, result);
    }

    @Test
    void testFindAllWithException() {
        when(mockMealRepository.findAll()).thenThrow(new RuntimeException("Simulated database exception"));

        MealServiceException exception = assertThrows(MealServiceException.class, () -> mealService.findAll());
    }

    @Test
    void testSaveMeal() {
        Meal meal = new Meal();

        mealService.saveMeal(meal);

        verify(mockMealRepository,times(1)).save(meal);
    }

    @Test
    void testSaveMeal2() {
        assertThrows(IllegalArgumentException.class, () -> mealService.saveMeal(null));
    }

    @Test
    void testSaveMeal3() {
        Meal meal = new Meal();
        meal.setMealName("Meal Name");

        mealService.saveMeal(meal);

        verify(mockMealRepository,times(1)).save(meal);
    }

    @Test
    void testGetMealById() {
        Person person1 = new Person(1L, "Bob", "bob123", "password1");
        MealRepository mockMealRepo = mock(MealRepository.class);
        mealService = new MealService(mockMealRepo);

//        Meal meal = new Meal(null,"Chicken Stir Fry", "Lunch", 500, "Stir-fry chicken with vegetables and soy sauce", new ArrayList<>(), person1.getId());
//        meal.getIngredients().add(new Ingredient((Set<Meal>) meal, "Chicken"));
//        meal.getIngredients().add(new Ingredient((Set<Meal>) meal, "Vegetables"));
//        meal.getIngredients().add(new Ingredient((Set<Meal>) meal, "Soy Sauce"));

//        when(mockMealRepo.findById(any())).thenReturn(Optional.of(meal));
//        Meal actual = mealService.getMealById(1L);
//
//        assertEquals(meal.getMealName(), actual.getMealName());
    }

    @Test
    void testRepoIsEmptyWhenEmpty() {
        when(mockMealRepository.findAll()).thenReturn(Collections.emptyList());

        boolean result = mealService.repoIsEmpty();

        assertTrue(result);
        verify(mockMealRepository, times(1)).findAll();
    }

    @Test
    void testRepoIsEmptyWhenNotEmpty() {
        List<Meal> nonEmptyList = List.of(new Meal());
        when(mockMealRepository.findAll()).thenReturn(nonEmptyList);

        boolean result = mealService.repoIsEmpty();

        assertFalse(result);
        verify(mockMealRepository, times(1)).findAll();
    }

    @Test
    void testGetMealByPersonIdAndDate() {
        Long personId = 1L;
        LocalDate date = LocalDate.now();
        List<Meal> expectedMeals = List.of(new Meal());

        when(mockMealRepository.findByPersonIdAndMealDate(personId, date))
                .thenReturn(expectedMeals);

        List<Meal> actualMeals = mealService.getMealByPersonIdAndDate(personId, date);

        assertThat(actualMeals).isEqualTo(expectedMeals);

        verify(mockMealRepository, times(1)).findByPersonIdAndMealDate(personId, date);
    }
}

