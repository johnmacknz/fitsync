package fitnesstracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#Person()}
     *   <li>{@link Person#setName(String)}
     *   <li>{@link Person#setPassword(String)}
     *   <li>{@link Person#setUsername(String)}
     *   <li>{@link Person#getId()}
     *   <li>{@link Person#getName()}
     *   <li>{@link Person#getPassword()}
     *   <li>{@link Person#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Person actualPerson = new Person();
        actualPerson.setName("Name");
        actualPerson.setPassword("iloveyou");
        actualPerson.setUsername("janedoe");
        actualPerson.getId();
        String actualName = actualPerson.getName();
        String actualPassword = actualPerson.getPassword();
        assertEquals("Name", actualName);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualPerson.getUsername());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Person#Person(Long, String, String, String)}
     *   <li>{@link Person#setName(String)}
     *   <li>{@link Person#setPassword(String)}
     *   <li>{@link Person#setUsername(String)}
     *   <li>{@link Person#getId()}
     *   <li>{@link Person#getName()}
     *   <li>{@link Person#getPassword()}
     *   <li>{@link Person#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Person actualPerson = new Person(1L, "Name", "janedoe", "iloveyou");
        actualPerson.setName("Name");
        actualPerson.setPassword("iloveyou");
        actualPerson.setUsername("janedoe");
        Long actualId = actualPerson.getId();
        String actualName = actualPerson.getName();
        String actualPassword = actualPerson.getPassword();
        assertEquals("Name", actualName);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualPerson.getUsername());
        assertEquals(1L, actualId.longValue());
    }
}
