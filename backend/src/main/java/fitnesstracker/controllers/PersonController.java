package fitnesstracker.controllers;

import fitnesstracker.entities.person.Person;
import fitnesstracker.services.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Person APIs")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        boolean isAuthenticated = personService.authenticateUser(email, password);

        if (isAuthenticated) {
            long personId = personService.getIdByEmailAndPassword(email, password);
            return ResponseEntity.ok(String.valueOf(personId));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Map<String, String> signUpData) {
        String firstName = signUpData.get("firstName");
        String lastName = signUpData.get("lastName");
        String email = signUpData.get("email");
        String password = signUpData.get("password");
        String reEnterPassword = signUpData.get("reEnterPassword");

        boolean emailInUse = personService.isEmailInUse(email);
        boolean passwordsMatch = password.equals(reEnterPassword);

        if (emailInUse) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User with this email already exists");
        } else if (!passwordsMatch) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Passwords do not match");
        } else {
            Person person = new Person(firstName, lastName, email, password);
            personService.savePerson(person);
            long personId = personService.getIdByEmailAndPassword(email, password);
            return ResponseEntity.ok(String.valueOf(personId));
        }
    }
}

