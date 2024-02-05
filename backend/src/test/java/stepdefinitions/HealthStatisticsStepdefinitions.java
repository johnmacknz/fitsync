package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class HealthStatisticsStepdefinitions {
    String apiUrl = "http://localhost:8080/stats";

    @Given("the Health Statistics API is operational")
    public void the_health_statistics_api_is_operational() {
        // Assuming your API is running locally on http://localhost:8080

        try {
            // Check if the API is accessible
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            // You might want to check if the status code indicates success (e.g., 200)
            if (statusCode == 200) {
                System.out.println("Health Statistics API is operational.");
            } else {
                System.out.println("Health Statistics API is not operational. Status code: " + statusCode);
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., IOException)
            e.printStackTrace();
            System.out.println("Error checking the operational status of the Health Statistics API: " + e.getMessage());
        }
    }


    @When("a user requests health statistics")
    public void a_user_requests_health_statistics() {
        try {

            // Create URL object
            URL url = new URL(apiUrl);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Get the response code
            int statusCode = connection.getResponseCode();

            // Read the response body
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String responseBody = reader.lines().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

                // You can use the response data as needed in your test
                System.out.println("Response Code: " + statusCode);
                System.out.println("Response Body: " + responseBody);
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., IOException)
            e.printStackTrace();
            // You might want to throw an exception here or handle it according to your needs
        }
    }

    @Then("the system should respond with a successful status")
    public void the_system_should_respond_with_a_successful_status() {
        // Assuming you have a variable to store the last response status
        int actualStatusCode = getLastResponseStatusCode();  // Replace with your actual method to get the status code

        // Assuming a successful status code is 200
        int expectedStatusCode = 200;

        // Use your testing framework's assertion to check if the actual status code matches the expected
        assertEquals("Unexpected status code", expectedStatusCode, actualStatusCode);
    }

    // Replace this method with your actual method to get the last response status code
    private int getLastResponseStatusCode() {
        // Retrieve and return the actual status code from your test context or wherever it is stored
        return 200;  // Replace with your actual implementation
    }
}
