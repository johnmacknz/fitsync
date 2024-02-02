package fitnesstracker.controllers;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.ExerciseHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/exercises")
@Tag(name = "Exercise History", description = "Exercise History APIs")
public class ExerciseHistoryController {

    ExerciseHistoryService exerciseHistoryService;

    @Autowired
    public ExerciseHistoryController(ExerciseHistoryService exerciseHistoryService) {
        this.exerciseHistoryService = exerciseHistoryService;
    }

    @GetMapping
    @Operation(summary = "Get all Exercises", description = "Returns a list of all exercises",
            tags = {"exercises", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema()) })
    })
    public Iterable<Exercise> getAllExercises() {
        try {
            return exerciseHistoryService.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching exercises", e);
        }
    }

    @GetMapping("/exercise/{exerciseId}")
    @Operation(summary = "Get an exercise by exercise ID", description = "Returns an exercise based on its ID",
            tags = {"exercises", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    public Exercise getExerciseById(@PathVariable Long exerciseId) {
        Exercise exercise = exerciseHistoryService.getExerciseById(exerciseId);
        if (exercise != null) {
            return exercise;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found");
        }
    }

    @GetMapping("/name/{exerciseName}")
    @Operation(summary = "Get an exercise by exercise name", description = "Returns an exercise based on its name",
            tags = {"exercises", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getExerciseByName(@PathVariable String exerciseName){
        return exerciseHistoryService.getExerciseByName(exerciseName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new Exercise", description = "Adds a new Exercise",
            tags = {"exercises", "post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public Exercise addNewExercise(@RequestBody(required = false) @Valid Exercise exercise) {
        Exercise newExercise;
        try {
                newExercise = exerciseHistoryService.addExercise(exercise);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return newExercise;
    }

    @DeleteMapping("/exercise/{id}")
    @Operation(summary = "Delete an Exercise by ID", description = "Deletes an Exercise based on its ID",
            tags = {"exercises", "delete"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    public void deleteExercise(@PathVariable long id){
        exerciseHistoryService.deleteById(id);
    }

    @GetMapping("/person/{personId}")
    @Operation(summary = "Get an exercise by person ID", description = "Returns all the exercises based on a person's ID",
            tags = {"exercises", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> findAllExercisesByPersonId(@PathVariable Long personId) {
        return exerciseHistoryService.findByPersonId(personId);
    }

    @GetMapping("/person/{personId}/{exerciseName}")
    @Operation(summary = "Get an exercise by person ID and exercise name", description = "Returns all the exercises with the same name that are under a specific person ID",
            tags = {"exercises", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> findAllExercisesByPersonIdAndExerciseName(@PathVariable  Long personId, @PathVariable String exerciseName) {
        return exerciseHistoryService.findExerciseByPersonIdAndExerciseName(personId, exerciseName);
    }
}
