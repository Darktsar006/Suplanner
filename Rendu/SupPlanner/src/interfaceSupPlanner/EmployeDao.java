package interfaceSupPlanner;

public interface EmployeDao {
	public boolean createEmploye(String lastname, String firstname, 
			String email, String passwordT, String passworTC,
			String role);
	public boolean loginEmploye(String email, String password);
}
