package fi.haagahelia.GymPlanner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.GymPlanner.domain.Coach;
import fi.haagahelia.GymPlanner.domain.CoachRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CoachRepositoryTest {
	@Autowired
	private CoachRepository repository;
	
	// Create a new coach test
    @Test
    public void createNewCoach() {
    	Coach coach = new Coach("Kobe");
    	repository.save(coach);
    	assertThat(coach.getCoachId()).isNotNull();
    }  
    

    
    // Find coach by name test
    @Test
    public void findByName() {
        List<Coach> coaches = repository.findByName("Jose Mourinho");
        
        assertThat(coaches).hasSize(1);
        assertThat(coaches.get(0).getName()).isEqualTo("Jose Mourinho");
    }
}
