package fi.haagahelia.GymPlanner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mariadb.jdbc.MariaDbClob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.haagahelia.GymPlanner.domain.Coach;
import fi.haagahelia.GymPlanner.domain.Training;
import fi.haagahelia.GymPlanner.domain.TrainingRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TrainingRepositoryTest {
	
		
	@Autowired
	private TrainingRepository repository;
	
	// Create a new training test
    @Test
    public void createNewTraining() {
    	Training training = new Training("Soccer", 60, "12-12-2020", new Coach("Kobe"));
    	repository.save(training);
    	assertThat(training.getId()).isNotNull();
    }  
    
    // Delete training test
    @Test
    public void deleteTraining() {
    	List<Training> trainings = repository.findByName("Zumba");
    	assertThat(trainings).hasSize(1);
    	repository.deleteById((long) 5);
    	trainings = repository.findByName("Zumba");
    	assertThat(trainings).hasSize(0);
    }
    
    // Find by name test
    @Test
    public void findByName() {
        List<Training> trainings = repository.findByName("Zumba");
        
        assertThat(trainings).hasSize(1);
        assertThat(trainings.get(0).getDuration()).isEqualTo(40);
    }
	
	

}
