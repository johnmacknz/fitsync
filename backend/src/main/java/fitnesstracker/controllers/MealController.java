package fitnesstracker.controllers;

import fitnesstracker.entities.meal.Meal;
import fitnesstracker.services.MealService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/meals")
@Tag(name = "Meals", description = "Meal APIs")
public class MealController {

    MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    @Operation(summary = "Get all Meals", description = "Returns a list of all Meals",
            tags = {"meals", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Meal.class), mediaType = "application/json") }, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema()) })
    })
    public List<Meal> getAllMeals() {
        try {
            return mealService.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching meals", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new Meal", description = "Adds a new Meal",
            tags = {"meals", "post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Meal.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public Meal addMeal(@RequestBody @NotNull Meal meal) {
        Meal newMeal;

        try {
            newMeal = this.mealService.saveMeal(meal);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return newMeal;
    }

    @GetMapping("/{mealId}")
    @Operation(summary = "Get a Meal by ID", description = "Returns a Meal based on its ID",
            tags = {"meals", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Meal.class), mediaType = "application/json") }, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    public Meal getMealById(@PathVariable Long mealId) {
        Meal meal = mealService.getMealById(mealId);
        if(meal == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal not found");
        return meal;
    }

    @Autowired
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
    }
}