package fi.haagahelia.GymPlanner;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.GymPlanner.domain.Coach;
import fi.haagahelia.GymPlanner.domain.CoachRepository;
import fi.haagahelia.GymPlanner.domain.Training;
import fi.haagahelia.GymPlanner.domain.TrainingRepository;
import fi.haagahelia.GymPlanner.domain.User;
import fi.haagahelia.GymPlanner.domain.UserRepository;



@SpringBootApplication
public class GymPlannerApplication {
	private static final Logger log = LoggerFactory.getLogger(GymPlannerApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(GymPlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TrainingRepository trepo, CoachRepository crepo, UserRepository urepo) {
		return (args) -> {
			
			// save some demo data coach
			Coach c1 = new Coach("Jose Mourinho");
			Coach c2 = new Coach("Zinedine Zidane");

			crepo.save(c1);
			crepo.save(c2);

			
			
			
			// save some demo data training
	        trepo.save(new Training("Cyling", 30, "24-03-2020, 11:00am", c1 ));
	        trepo.save(new Training("Yoga", 60, "24-03-2020, 12:00am", c2 ));
	        trepo.save(new Training("Zumba", 40, "24-03-2020, 10:00am", c2));
	       
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepo.save(user1);
			urepo.save(user2);
		};
	}	
}
