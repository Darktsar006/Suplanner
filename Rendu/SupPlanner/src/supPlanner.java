import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

import java.sql.*;

import managerSupPlanner.Project;
import jdbcSupPlanner.*;
import SuPlannerGui.*;

public class supPlanner {
	
	public static void main(String[] args) {
		
		try
		{
			Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/supplannerprojet", "root", "root");
		
			//GUI g = new GUI(connection);
			GUIUserLogin t = new GUIUserLogin(connection);
			
			//JdbcProjectDao p = new JdbcProjectDao(connection);
			
			//Project[] compile = new Project[100];
			
			//p.displatAllProject(compile);
			
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Nope");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Plop");
		}
		
		
	}

}
