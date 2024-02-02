package fitnesstracker.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import fitnesstracker.entities.Person;
import fitnesstracker.repositories.PersonRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testRepoIsEmpty() {
        when(personRepository.findAll()).thenReturn(Collections.emptyList());

        boolean isEmpty = personService.repoIsEmpty();

        assertTrue(isEmpty);
    }

    @Test
    void testRepoIsNotEmpty() {
        List<Person> nonEmptyList = List.of(new Person(), new Person());
        when(personRepository.findAll()).thenReturn(nonEmptyList);

        boolean isEmpty = personService.repoIsEmpty();

        assertFalse(isEmpty);
    }

    @Test
    void testSavePerson() {
        Person mockPerson = new Person();
        mockPerson.setName("John Doe");
        when(personRepository.save(Mockito.any(Person.class))).thenAnswer(invocation -> {
            return invocation.<Person>getArgument(0);
        });
        Person savedPerson = personService.savePerson(mockPerson);
        assertEquals("John Doe", savedPerson.getName());
    }
}
