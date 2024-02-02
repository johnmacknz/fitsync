package fitnesstracker.services;

import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.repositories.HealthStatisticRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class HealthStatisticServiceTest {

    @MockBean
    private HealthStatisticRepository mockHealthStatisticRepository;

    @Autowired
    private HealthStatisticService healthStatisticService;

    HealthStatistic healthStatistic;

    @BeforeEach
    void loadData(){
        healthStatistic = new HealthStatistic();
    }

    @Test
    void getAllHealthStatistics() {
        healthStatisticService.getAllHealthStatistics();

        verify(mockHealthStatisticRepository, times(1)).findAll();
    }

    @Test
    void getHealthStatisticById() {
        healthStatisticService.getHealthStatisticById(healthStatistic.getPersonId());

        verify(mockHealthStatisticRepository, times(1)).findById(healthStatistic.getPersonId());
    }

    @Test
    void  createHealthStatistic() {
        healthStatisticService.createHealthStatistic(healthStatistic);

        verify(mockHealthStatisticRepository, times(1)).save(healthStatistic);
    }

    @Test
    void deleteHealthStatistic() {
        healthStatisticService.deleteHealthStatistic(healthStatistic.getPersonId());

        verify(mockHealthStatisticRepository, times(1)).deleteById(healthStatistic.getPersonId());
    }

    @Test
    void repoIsEmpty() {
        healthStatisticService.repoIsEmpty();

        verify(mockHealthStatisticRepository, times(1)).findAll();
    }

    @Test
    void testExistsByPersonId() {
        Long personId = 123L;
        when(mockHealthStatisticRepository.existsByPersonId(personId)).thenReturn(true);
        boolean result = healthStatisticService.existsByPersonId(personId);
        assertTrue(result);
        verify(mockHealthStatisticRepository, times(1)).existsByPersonId(personId);
    }
}