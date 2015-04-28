package managerSupPlanner;

import java.util.*;

public class Project {
	private int id;
	private int number_Of_Employe;
	private int project_completion;
	private String name;
	private String author;
	private Date start_Time;
	private Date end_Time;
	
	
	public Project()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber_Of_Employe() {
		return number_Of_Employe;
	}

	public void setNumber_Of_Employe(int number_Of_Employe) {
		this.number_Of_Employe = number_Of_Employe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getStart_Time() {
		return start_Time;
	}

	public void setStart_Time(Date start_Time) {
		this.start_Time = start_Time;
	}

	public Date getEnd_Time() {
		return end_Time;
	}

	public void setEnd_Time(Date end_Time) {
		this.end_Time = end_Time;
	}

	public int getProject_completion() {
		return project_completion;
	}

	public void setProject_completion(int project_completion) {
		this.project_completion = project_completion;
	}
}
