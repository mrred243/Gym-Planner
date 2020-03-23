package fi.haagahelia.GymPlanner;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.GymPlanner.web.TrainingController;
import fi.haagahelia.GymPlanner.web.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class GymPlannerApplicationTests {
	
	// Smoke testing
	@Autowired
	private TrainingController controller;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}

}
