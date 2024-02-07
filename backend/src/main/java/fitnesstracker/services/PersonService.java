package fitnesstracker.services;

import fitnesstracker.entities.person.Person;
import fitnesstracker.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean repoIsEmpty() {
        return personRepository.findAll().isEmpty();
    }

    public Person savePerson(Person person){
        return this.personRepository.save(person);

    }

    public boolean authenticateUser(String email, String password) {
        return personRepository.existsByEmailAndPassword(email, password);
    }

    public boolean isEmailInUse(String email) {
        return personRepository.existsByEmail(email);
    }

    public long getIdByEmailAndPassword(String email, String password) {
        Person person = personRepository.findByEmailAndPassword(email, password);
        return person.getId();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
