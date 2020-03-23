package fi.haagahelia.GymPlanner.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "coach")

public class Coach {
	
	// Declare parameter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long coachId;
	private String name;
	
	// Add relation one to many to Training table
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "coach")
	private List <Training> trainings;
	
	
	
	
	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public Coach(long id, String name) {
		this.coachId = id;
		this.name = name;
	}
	
	public Coach() {
		super();
	}
	
	public Coach(String name) {
		this.coachId = 0;
		this.name = name;
	}

	public long getCoachId() {
		return coachId;
	}
	public void setCoachId(long id) {
		this.coachId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
