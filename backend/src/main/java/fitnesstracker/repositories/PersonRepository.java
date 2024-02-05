package fitnesstracker.repositories;

import fitnesstracker.entities.person.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Long> {

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
