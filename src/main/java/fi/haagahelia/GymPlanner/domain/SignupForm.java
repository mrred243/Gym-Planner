package fi.haagahelia.GymPlanner.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SignupForm {

	//Set up User entity for sign up new user
	@NotEmpty
	@Size(min = 5, max =30)
	private String username = "";
	
	@NotEmpty
	@Size( min = 7, max = 30)
	private String password = "";
	
	@NotEmpty
	@Size( min = 7, max = 30)
	private String passwordCheck = "";
	
	public String getUsername() {
		return username;
	}
	
    @NotEmpty
    private String role = "USER";
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public  String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
