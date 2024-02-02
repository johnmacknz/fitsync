package fitnesstracker;

import fitnesstracker.data.DataPopulate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FitnessTrackerApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(FitnessTrackerApplication.class, args);

		DataPopulate dataPopulate = context.getBean(DataPopulate.class);

		dataPopulate.populateData();
	}
}
