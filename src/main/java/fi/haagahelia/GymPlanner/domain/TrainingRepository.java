package fi.haagahelia.GymPlanner.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<Training, Long> {
	
	//Declare query methods on the interface
	List <Training> findByName(String name);
}
