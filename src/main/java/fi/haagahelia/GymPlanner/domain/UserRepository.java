package fi.haagahelia.GymPlanner.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	//Delare query method
	User findByUsername(String username);
}
