package fitnesstracker.controllers;

import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.services.HealthStatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
@Tag(name = "Health Statistics", description = "Health Statistics APIs")
public class HealthStatisticController {

    private final HealthStatisticService healthStatisticService;

    @Autowired
    public HealthStatisticController(HealthStatisticService healthStatisticService) {
        this.healthStatisticService = healthStatisticService;
    }

    @GetMapping
    @Operation(summary = "Get all Health Statistics", description = "Returns all Health Statistics data",
            tags = {"stats", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = HealthStatistic.class), mediaType = "application/json")}, description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The Health Statistics were not found", content = {@Content(schema = @Schema())})
    })
    public List<HealthStatistic> getAllHealthStatistics(
    ) {
        return healthStatisticService.getAllHealthStatistics();
    }
    @Operation(summary = "Get all Health Statistics", description = "Get all Health Statistics per id",
            tags = {"stats", "get"})
    @GetMapping("/{id}")
    public ResponseEntity<HealthStatistic> getHealthStatisticById(@PathVariable Long id) {
        try {
            HealthStatistic healthStatistic = healthStatisticService.getHealthStatisticById(id);
            return ResponseEntity.ok(healthStatistic);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Post data to Health Statistics", description = "Post Health Statistics",
            tags = {"stats", "post"})
    @PostMapping
    public ResponseEntity<HealthStatistic> createHealthStatistic(@RequestBody @NotNull HealthStatistic healthStatistic) {
        @SuppressWarnings("unused")
        Long personId = healthStatistic.getPersonId();

        // Check if personId already exists
        if (!healthStatisticService.existsByPersonId(personId)) {
            // PersonId does not exists, return an error response
            throw new EntityNotFoundException("Person with ID " + personId + " not found.");
        } else {
            HealthStatistic createdHealthStatistic = healthStatisticService.createHealthStatistic(healthStatistic);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthStatistic);
        }
    }
    @Operation(summary = "Delete data from Health Statistics", description = "Delete Health Statistics",
            tags = {"stats", "delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthStatistic(@PathVariable Long id) {
        healthStatisticService.deleteHealthStatistic(id);
        return ResponseEntity.noContent().build();
    }
}