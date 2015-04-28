package managerSupPlanner;

import java.util.Scanner;

public class Employe {
	private int id;
	private String last_name;
	private String first_name;
	private String email;
	private String password;
	private String role;
	
	Scanner sc = new Scanner(System.in);
	
	public Employe()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String lastname) {
		this.last_name = lastname;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String firstname) {
		this.first_name = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
