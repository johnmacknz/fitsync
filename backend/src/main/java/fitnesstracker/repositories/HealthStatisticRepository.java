package fitnesstracker.repositories;

import fitnesstracker.entities.health.HealthStatistic;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HealthStatisticRepository extends ListCrudRepository<HealthStatistic, Long> {
    boolean existsByPersonId(Long personId);

    List<HealthStatistic> findByPersonId(Long personId);
}
