package fitnesstracker.entities.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    void testConstructor() {
        Person actualPerson = new Person();
        actualPerson.setFirstName("Jane");
        actualPerson.setLastName("Doe");
        actualPerson.setPassword("iloveyou");
        actualPerson.setEmail("janedoe");
        String actualName = actualPerson.getFullName();
        String actualFirstName = actualPerson.getFirstName();
        String actualLastName = actualPerson.getLastName();
        String actualPassword = actualPerson.getPassword();
        assertEquals("Jane Doe", actualName);
        assertEquals("Jane", actualFirstName);
        assertEquals("Doe", actualLastName);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualPerson.getEmail());
    }
    @Test
    void testConstructor2() {
        Person actualPerson = new Person(1L, "Jane", "Doe", "janedoe", "iloveyou");
        actualPerson.setFirstName("Jane");
        actualPerson.setLastName("Doe");
        actualPerson.setPassword("iloveyou");
        actualPerson.setEmail("janedoe");
        Long actualId = actualPerson.getId();
        String actualName = actualPerson.getFullName();
        String actualFirstName = actualPerson.getFirstName();
        String actualLastName = actualPerson.getLastName();
        String actualPassword = actualPerson.getPassword();
        assertEquals("Jane Doe", actualName);
        assertEquals("Jane", actualFirstName);
        assertEquals("Doe", actualLastName);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualPerson.getEmail());
        assertEquals(1L, actualId.longValue());
    }
}
