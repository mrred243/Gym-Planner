package fi.haagahelia.GymPlanner.domain;

import java.util.Date;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "training")
public class Training {
	
	// Declare training entities
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int duration;
	private String date;
	
	// Add relation to Coach table
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "coachId")
	public Coach coach;
	
	
	
	public Training() {
		this.id = 0;
		this.name = null;
		this.duration = 0;
		this.date = "dd-mm-yyyy, hh:mm";
	}

	public Training(long id, String name, int duration, String date, Coach coach ) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.coach = coach;
		this.date = date;
	}


	public Training(String name, int duration, String date, Coach coach) {
		this.id = 0;
		this.name = name;
		this.duration = duration;
		this.coach = coach;
		this.date = date;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setCoach(Coach coach) {
		// TODO Auto-generated method stub
		this.coach = coach;
	}
	
	public Coach getCoach() {
		return coach;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
