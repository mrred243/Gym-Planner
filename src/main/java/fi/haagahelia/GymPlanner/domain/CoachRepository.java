package fi.haagahelia.GymPlanner.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface CoachRepository extends CrudRepository<Coach, Long> {

//	Declare query method on the interface
	List<Coach> findByName(String name);
}
