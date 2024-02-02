package fitnesstracker.controllers;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.PersonalBestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercises/pb")
public class PersonalBestController {

    PersonalBestService personalBestService;
    @Autowired
    public PersonalBestController(PersonalBestService personalBestService) {
        this.personalBestService = personalBestService;
    }

    @GetMapping("/weight/{personId}/{exerciseName}")
    @Operation(summary = "Gets the personal best weight lifted for a person for a particular exercise.", description = "Returns personal best weight lifted for specified exercise.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestWeightByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/duration/{personId}/{exerciseName}")
    @Operation(summary = "Gets the personal best duration for a person for a particular exercise.", description = "Returns personal best duration for specified exercise.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestDurationByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/distance/{personId}/{exerciseName}")
    @Operation(summary = "Gets the personal best distance travelled for a person for a particular exercise.", description = "Returns personal best distance travelled for specified exercise.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestDistanceByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/reps/{personId}/{exerciseName}")
    @Operation(summary = "Gets the personal best reps for a person for a particular exercise.", description = "Returns personal best reps for specified exercise.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestRepsByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/sets/{personId}/{exerciseName}")
    @Operation(summary = "Gets the personal best sets for a person for a particular exercise.", description = "Returns personal best sets for specified exercise.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestSetsByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/weight/{personId}")
    @Operation(summary = "Gets the personal best weights lifted for a person for all exercises.", description = "Returns personal best weights lifted for all exercises.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestWeightPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestWeightByPersonId(personId);
    }

    @GetMapping("/duration/{personId}")
    @Operation(summary = "Gets the personal duration for a person for all exercises.", description = "Returns personal best duration for all exercises.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestDurationPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestDurationByPersonId(personId);
    }

    @GetMapping("/distance/{personId}")
    @Operation(summary = "Gets the personal best distance travelled for a person for all exercises.", description = "Returns personal best distance travelled for all exercises.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestDistancePersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestDistanceByPersonId(personId);
    }

    @GetMapping("/reps/{personId}")
    @Operation(summary = "Gets the personal best reps for a person for all exercises.", description = "Returns personal best reps for all exercises.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestRepsPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestRepsByPersonId(personId);
    }

    @GetMapping("/sets/{personId}")
    @Operation(summary = "Gets the personal best sets for a person for all exercises.", description = "Returns personal best sets for all exercises.",
            tags = {"personalbests", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Exercise.class), mediaType = "application/json") }, description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema()) })
    })
    public List<Exercise> getPersonalBestSetsPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestSetsByPersonId(personId);
    }

}
