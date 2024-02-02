package fitnesstracker.repositories;

import fitnesstracker.entities.Person;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonRepository extends ListCrudRepository<Person, Long> {

}
