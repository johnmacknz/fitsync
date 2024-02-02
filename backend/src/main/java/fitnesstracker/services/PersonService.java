package fitnesstracker.services;

import fitnesstracker.entities.Person;
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
}
