package fitnesstracker.repositories;

import fitnesstracker.entities.health.HealthStatistic;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthStatisticRepository extends ListCrudRepository<HealthStatistic, Long> {
    boolean existsByPersonId(Long personId);
}
