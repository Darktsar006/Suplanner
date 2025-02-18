package jdbcSupPlanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import managerSupPlanner.Task;
import interfaceSupPlanner.TaskDao;

public class JdbcTaskDao implements TaskDao {
	Scanner sc = new Scanner(System.in);
	private Connection connection;
	
	private int count;
	
	private String[] idParametre;
	
	public JdbcTaskDao(Connection c)
	{
		this.connection = c;
		this.count = 0;
		
		this.idParametre = new String[100];
	}
	
	public Task[] displayAllTask()
	{
		Task[] toto = new Task[100];
		
		try
		{
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM task");
			while(rs.next())
			{	
				toto[count] = new Task();
				
				toto[count].setId(Integer.parseInt(rs.getString("idTask")));
				toto[count].setName(rs.getString("name"));
				toto[count].setStart_Time(rs.getDate("start_time"));
				toto[count].setEnd_Time(rs.getDate("end_time"));
				toto[count].setEmploye_working(Integer.parseInt(rs.getString("employe_working")));
				toto[count].setTask_completion(Integer.parseInt(rs.getString("task_completion")));
				
				count++;
			}
		}catch(Exception e)
		{
		}
		
		Task[] finale = new Task[count];
		
		for(int i = 0; i<count; i++)
		{
			finale[i] = toto[i];
		}
		return finale;
	}
	
	public boolean createTask(String name, int number, int completion) {
		// TODO Auto-generated method stub
		Task compile = new Task();
		
		compile.setName(name);
		
		compile.setTask_completion(completion);
		
		compile.setEmploye_working(number);;
		
		try
		{
			PreparedStatement pstm = connection.prepareStatement("INSERT INTO task (name, employe_working, task_completion)"
				+ "VALUES (?, ?, ?)");
			pstm.setString(1, compile.getName());
			pstm.setInt(2, compile.getEmploye_working());
			pstm.setInt(3, compile.getTask_completion());
			
			pstm.executeUpdate();
		}catch(Exception e)
		{
			
		}
		
		return false;
	}

	public String[] idParametre()
	{
		int i = 0;
		try
		{
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM project");
			while(rs.next())
			{	
				idParametre[i] = rs.getString("idProject");
				i++;
			}
		}catch(Exception e)
		{
		}
		return idParametre;
	}
	
	public boolean modifyTask(int idT, String name, 
			int numberX, int completionX) {
		// TODO Auto-generated method stub
		
		Task compile = new Task();
		
		compile.setName(name);
		compile.setEmploye_working(numberX);
		compile.setTask_completion(completionX);
		
		try
		{
			PreparedStatement pstm = connection.prepareStatement("UPDATE task "
					+ "SET name = ?, "
					+ "employe_working = ?, task_completion = ?"
					+ " WHERE idtask = ?");
			
			pstm.setString(1, compile.getName());
			pstm.setInt(2, compile.getEmploye_working());
			pstm.setInt(3, compile.getTask_completion());
			pstm.setInt(4, idT);
			
			pstm.executeUpdate();
			
			return true;
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean inviteOther() {
		// TODO Auto-generated method stub
		return false;
	}

}
