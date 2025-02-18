package SuPlannerGui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import managerSupPlanner.Project;
import managerSupPlanner.Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import jdbcSupPlanner.*;

public class GUIUserLogin extends JFrame implements MenuListener, ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
	// Menu Principale
	private JMenuBar menuBar = new JMenuBar();
	private JMenu login = new JMenu("Login");
	private JMenu create = new JMenu("Sign in");
	private JMenu project = new JMenu("Project");
	private JMenu task = new JMenu("Task");;
	
	private int choixMenu; 
	
	private String[] entetes = {"ID", "Name", "Author", "Number Employer",
			"Completion", "Start Time", "End Time"};
	private String[] entetes2 = {"ID", "Name", "Start Time",
			"End Time", "Number Employer",
			"Completion"};
	
	// Panel
	private JPanel panel1 = new JPanel(); 	
	
	// Panel Pour le contenu
	private JPanel panel2 = new JPanel(); // Pour le login
	private JScrollPane panelProject =  panelSelected3();
	private JScrollPane panelTask =  panelSelected4();
	
	private JPanel panelMessage = new JPanel();	
	
	
	// Section Login
	private JLabel JLabelEmail = new JLabel("Email\t ");
	private JLabel JLabelEmailCompletion = new JLabel("@supinfo.com");
	private JTextField JTextEmail = new JTextField(12);
	private JLabel JLabelPassword = new JLabel("Password\t ");
	private JTextField JTextPassword = new JTextField(12);
	
	private JButton JButtonSubmit = new JButton("Submit");
	
	private GridBagConstraints c;;
	
	// Section Create Salary
	private JLabel JLabelLastName = new JLabel("LastName\t ");
	private JTextField JTextLastName = new JTextField(12);
	private JLabel JLabelFirstName = new JLabel("\tFirstName");
	private JTextField JTextFirstName = new JTextField(12);
	private JLabel JLabelPasswordC = new JLabel("\t Confirm Password");
	private JTextField JTextPasswordC = new JTextField(12);
	private JLabel JLabelRole = new JLabel("Role\t ");
	private String[] role = {"Manager", "Employe"};
	private JComboBox<?> JComboBoxRole = extracted();

	private JComboBox<Object> extracted() {
		return new JComboBox<Object>(role);
	}

	private JComboBox JComboBoxModify;
	
	// Section Footer
	JLabel jLabelMessage = new JLabel("OK");
	JButton JButtonModidy = new JButton("Save Change");
	JButton JButtonAdd = new JButton("Add");
	
	private Project[] compiles;
	private Task[] compiles2;
	
	public GUIUserLogin(Connection d)
	{
		connection = d;;
		choixMenu = 0;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(800, 700);
		this.setTitle("Sup Planner B2");
		this.setBounds(50, 50, 800, 700);
		
		this.setJMenuBar(menuBar);
		
		c= new GridBagConstraints();
		
		menuBar.add(login);
		menuBar.add(create);
		menuBar.add(project);
		menuBar.add(task);
		
		this.getContentPane().add(panelMessage, BorderLayout.SOUTH);
		panel2.setLayout(new GridBagLayout());
		
		panelMessage.add(jLabelMessage);
		
		// Listener
		JButtonSubmit.addActionListener(this);
		JButtonModidy.addActionListener(this);
		JButtonAdd.addActionListener(this);
		
		login.addMenuListener(this);
		create.addMenuListener(this);
		project.addMenuListener(this);
		task.addMenuListener(this);
	}

	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
	}

	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void panelSelected1()
	{
		choixMenu = 1;
		
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		this.remove(panel1);
		this.remove(panelProject);
		this.remove(panelTask);
		this.setSize(800, 700);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new GridBagLayout());
		
		c.gridx = 0;	c.gridy = 0;
		c.insets = new Insets(0,0,0,0);
		panel2.add(JLabelLastName, c);
		
		c.gridx = 1;	c.gridy = 0;
		panel2.add(JTextLastName, c);
		
		c.gridx = 2;	c.gridy = 0;
		panel2.add(JTextFirstName, c);
		
		c.gridx = 3;	c.gridy = 0;
		c.insets = new Insets(0,0,0,0);
		panel2.add(JLabelFirstName, c);
		
		
		c.gridx = 0; c.gridy = 1;
		panel2.add(JLabelPassword, c);
		
		c.gridx = 1; c.gridy = 1;
		panel2.add(JTextPassword, c);
		
		c.gridx = 2;	c.gridy = 1;
		panel2.add(JTextPasswordC, c);
		
		c.gridx = 3;	c.gridy = 1;
		c.insets = new Insets(0,0,0,0);
		panel2.add(JLabelPasswordC, c);
		
		
		c.gridx = 0;	c.gridy = 2;
		c.insets = new Insets(0,0,0,0);
		panel2.add(JLabelEmail, c);
		
		c.gridx = 1;	c.gridy = 2;
		panel2.add(JTextEmail, c);
		
		c.gridx = 2;	c.gridy = 2;
		c.insets = new Insets(0,0,0,0);
		panel2.add(JLabelEmailCompletion, c);
		
		
		c.gridx = 0;	c.gridy = 3;
		c.insets = new Insets(0,0,0,0);
		panel2.add(JLabelRole, c);
		
		c.gridx = 1;	c.gridy = 3;
		panel2.add(JComboBoxRole, c);
		
		
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(20,0,0,0);
		panel2.add(JButtonSubmit, c);
	}
	
	public void panelSelected2()
	{
		choixMenu = 0;
		
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		this.getContentPane().add(panel1, BorderLayout.CENTER);
		this.remove(panel2);
		this.remove(panelProject);
		this.remove(panelTask);
		panel1.setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,0,0);
		panel1.add(JLabelEmail, c);
		
		c.gridx = 1;
		c.gridy = 0;
		panel1.add(JTextEmail, c);
		
		c.gridx = 0;
		c.gridy = 1;
		panel1.add(JLabelPassword, c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel1.add(JTextPassword, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(20,0,0,0);
		panel1.add(JButtonSubmit, c);
	}
	
	public JScrollPane panelSelected3()
	{
		choixMenu = 2;
		
		DateFormat df = new SimpleDateFormat("yyy-MM-dd");
		
		JdbcProjectDao manager = new JdbcProjectDao(connection);
		
		compiles = manager.displatAllProject();;
		
		
		Object[][] projectContent = new Object[100][7];
		
		if(compiles.length > 0)
		{
			for(int i = 0; i < compiles.length; i++)
			{
				projectContent[i][0] = Integer.toString(compiles[i].getId());
				projectContent[i][1] = compiles[i].getName();
				projectContent[i][2] = compiles[i].getAuthor();
				projectContent[i][3] = Integer.toString(
						compiles[i].getNumber_Of_Employe()
						);
				projectContent[i][4] = Integer.toString(
						compiles[i].getProject_completion()
						);
				projectContent[i][5] = df.format(
						compiles[i].getStart_Time()
						);
				projectContent[i][6] = df.format(
						compiles[i].getEnd_Time()
						);
			}
		}
		else
		{
		}
		JTable panel80 = new JTable(projectContent, entetes); // Pour les projects sous forme de Table
		JScrollPane panel10 = new JScrollPane(panel80);
		this.remove(panel1);
		this.remove(panel2);
		
		//fireTableRowsInserted(projectContent.length -1,  projectContent.length -1);
		panel80.setLayout(new GridBagLayout());
		panel10.setLayout(new ScrollPaneLayout());
		
		pack();
		
		return panel10;
	}
	
	public JScrollPane panelSelected4()
	{
		choixMenu = 3;
		
		DateFormat df = new SimpleDateFormat("yyy-MM-dd");
		
		JdbcTaskDao manager = new JdbcTaskDao(connection);
		
		compiles2 = manager.displayAllTask();
		
		
		Object[][] taskContent = new Object[100][6];
		
		if(compiles2.length > 0)
		{
			System.out.println("\n Partie 2 " + compiles2.length);
			for(int i = 0; i < compiles2.length; i++)
			{
				taskContent[i][0] = Integer.toString(compiles2[i].getId());
				taskContent[i][1] = compiles2[i].getName();
				taskContent[i][2] = df.format(
						compiles2[i].getStart_Time()
						);
				taskContent[i][3] = df.format(
						compiles2[i].getEnd_Time()
						);
				taskContent[i][4] = Integer.toString(
						compiles2[i].getEmploye_working()
						);
				taskContent[i][5] = Integer.toString(
						compiles2[i].getTask_completion()
						);
			}
		}
		else
		{
		}
		JTable panel8 = new JTable(taskContent, entetes2); // Pour les projects sous forme de Table
		JScrollPane panel9 = new JScrollPane(panel8);
		this.remove(panel1);
		this.remove(panel2);
		this.remove(panelProject);
		//fireTableRowsInserted(projectContent.length -1,  projectContent.length -1);
		panel8.setLayout(new GridBagLayout());
		panel9.setLayout(new ScrollPaneLayout());
		
		pack();
		
		return panel9;
	}
	
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == create)
		{
			panelSelected1();
			jLabelMessage.setText("Create Salary");
			
			panelMessage.remove(JButtonModidy);
			panelMessage.remove(JButtonAdd);
		}
		else if (e.getSource() == login)
		{
			panelSelected2();
			jLabelMessage.setText("Login Section");
			
			panelMessage.remove(JButtonModidy);
			panelMessage.remove(JButtonAdd);
		}
		else if (e.getSource() == project)
		{
			panelMessage.remove(jLabelMessage);
			
			panelProject = panelSelected3();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
			this.remove(panelTask);
			this.getContentPane().add(panelProject, BorderLayout.CENTER);
			this.setSize(800, 700);
			jLabelMessage.setText("Project Views");
			
			panelMessage.add(JButtonModidy);
			panelMessage.add(jLabelMessage);
			panelMessage.add(JButtonAdd);
		}
		else if (e.getSource() == task)
		{
			panelMessage.remove(jLabelMessage);
			
			panelTask = panelSelected4();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
			this.getContentPane().add(panelTask, BorderLayout.CENTER);
			this.setSize(800, 700);
			jLabelMessage.setText("Task Views");
			
			panelMessage.add(JButtonModidy);
			panelMessage.add(jLabelMessage);
			panelMessage.add(JButtonAdd);
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == JButtonSubmit)
		{
			JdbcEmployeDao t = new JdbcEmployeDao(connection);
			String email = JTextEmail.getText();
			String password = JTextPassword.getText();
			String passwordT = JTextPasswordC.getText();
			
			String lastname = JTextLastName.getText();
			String firstname = JTextFirstName.getText();
			String role = (String) JComboBoxRole.getSelectedItem();
			
			System.out.println(role);
			
			switch(choixMenu)
			{
				case 0: // Menu Login
					if(t.loginEmploye(email, password))
					{
						jLabelMessage.setText("Login successful");
					}
					else
					{
						jLabelMessage.setText("Login failed");
					}
					break;
				case 1: // Menu Sign in
					if(t.createEmploye(lastname, firstname, 
							email, password, passwordT,
							role))
					{
						jLabelMessage.setText("Salary Created");
					}
					else
					{
						jLabelMessage.setText("Create Fail ! Verify the password content 1 lettre UpperCase and 1 number a containt 8 caractere or "
								+ "email not contain @");
					}
					break;
			}
		}
		if(e.getSource() == JButtonAdd)
		{
			if(choixMenu == 2)
			{
				final JDialog newF = new JDialog();
				newF.setVisible(true);
				newF.setTitle("Add Project");
				newF.setBounds(150, 150, 400, 300);
				
				JPanel contentP = new JPanel();
				
				newF.getContentPane().add(contentP, BorderLayout.CENTER);
				contentP.setLayout(new GridBagLayout());
				
				JLabel JLabelProjectName = new JLabel("Name");
				c.gridx = 0;	c.gridy = 0;
				contentP.add(JLabelProjectName, c);
				final JTextField JTextProjectName = new JTextField(12);
				c.gridx = 1;	c.gridy = 0;
				contentP.add(JTextProjectName, c);
				
				JLabel JLabelProjectAuthor = new JLabel("Author");
				c.gridx = 0;	c.gridy = 1;
				contentP.add(JLabelProjectAuthor, c);
				final JTextField JTextProjectAuthor = new JTextField(12);
				c.gridx = 1;	c.gridy = 1;
				contentP.add(JTextProjectAuthor, c);
				
				JLabel JLabelProjectNumber = new JLabel("Number Employe");
				c.gridx = 0;	c.gridy = 2;
				contentP.add(JLabelProjectNumber, c);
				final JTextField JTextProjectNumber = new JTextField(12);
				c.gridx = 1;	c.gridy = 2;
				contentP.add(JTextProjectNumber, c);
				
				JLabel JLabelProjectCompletion = new JLabel("Completion");
				c.gridx = 0;	c.gridy = 3;
				contentP.add(JLabelProjectCompletion, c);
				final JTextField JTextProjectCompletion = new JTextField(12);
				c.gridx = 1;	c.gridy = 3;
				contentP.add(JTextProjectCompletion, c);
				
				JButton submitProject = new JButton("Submit Project");
				c.gridx = 0;	c.gridy = 4;
				contentP.add(submitProject, c);
				
				submitProject.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try
						{
							Project t = new Project();
							JdbcProjectDao manager = new JdbcProjectDao(connection);
						
							t.setName(JTextProjectName.getText());
							t.setAuthor(JTextProjectAuthor.getText());
							int number = Integer.parseInt(JTextProjectNumber.getText());
							int completion = Integer.parseInt(JTextProjectCompletion.getText());
						
							manager.createProject(t.getName(), t.getAuthor(), 
								number, completion);
						
							newF.setVisible(false);					
						}
						catch(Exception e)
						{
							jLabelMessage.setText("Completion (0 - 100) and  Number Employe must be a Number");
						}
					}
				});
			}
			else
			{
				final JDialog newF = new JDialog();
				newF.setVisible(true);
				newF.setTitle("Add Task");
				newF.setBounds(150, 150, 400, 300);
				
				JPanel contentT = new JPanel();
				
				newF.getContentPane().add(contentT, BorderLayout.CENTER);
				contentT.setLayout(new GridBagLayout());
				
				JLabel JLabelTaskName = new JLabel("Name");
				c.gridx = 0;	c.gridy = 0;
				contentT.add(JLabelTaskName, c);
				final JTextField JTextTaskName = new JTextField(12);
				c.gridx = 1;	c.gridy = 0;
				contentT.add(JTextTaskName, c);
				
				JLabel JLabelTaskNumber = new JLabel("Number Employe");
				c.gridx = 0;	c.gridy = 1;
				contentT.add(JLabelTaskNumber, c);
				final JTextField JTextTaskNumber = new JTextField(12);
				c.gridx = 1;	c.gridy = 1;
				contentT.add(JTextTaskNumber, c);
				
				JLabel JLabelTaskCompletion = new JLabel("Completion");
				c.gridx = 0;	c.gridy = 2;
				contentT.add(JLabelTaskCompletion, c);
				final JTextField JTextTaskCompletion = new JTextField(12);
				c.gridx = 1;	c.gridy = 2;
				contentT.add(JTextTaskCompletion, c);
				
				JButton submitTask = new JButton("Submit Task");
				c.gridx = 0;	c.gridy = 4;
				contentT.add(submitTask, c);
				
				submitTask.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try
						{
							Task t = new Task();
							JdbcTaskDao manager = new JdbcTaskDao(connection);
						
							t.setName(JTextTaskName.getText());
							int number = Integer.parseInt(JTextTaskNumber.getText());
							int completion = Integer.parseInt(JTextTaskCompletion.getText());
						
							manager.createTask(t.getName(), 
								number, completion);
						
							newF.setVisible(false);					
						}
						catch(Exception e)
						{
							jLabelMessage.setText("Completion (0 - 100) and  Number Employe must be a Number");
						}
					}
				});

			}
		}
		if(e.getSource() == JButtonModidy)
		{
			if(choixMenu == 2)
			{
				final JdbcProjectDao manager = new JdbcProjectDao(connection);
				
				String[] idProject = manager.idParametre();
				
				
				final JDialog newF = new JDialog();
				newF.setVisible(true);
				newF.setTitle("Add Task");
				newF.setBounds(150, 150, 400, 300);
				
				JPanel contentP = new JPanel();
				
				newF.getContentPane().add(contentP, BorderLayout.CENTER);
				contentP.setLayout(new GridBagLayout());
				
				JLabel JLabelProjectSelection = new JLabel("Chose Your Project");
				c.gridx = 0;	c.gridy = 0;
				contentP.add(JLabelProjectSelection, c);
				JComboBoxModify = new JComboBox(idProject);
				c.gridx = 1;	c.gridy = 0;
				contentP.add(JComboBoxModify, c);
				
				JLabel JLabelProjectName = new JLabel("Name");
				c.gridx = 0;	c.gridy = 1;
				contentP.add(JLabelProjectName, c);
				final JTextField JTextProjectName = new JTextField(12);
				c.gridx = 1;	c.gridy = 1;
				contentP.add(JTextProjectName, c);
				
				JLabel JLabelProjectAuthor = new JLabel("Author");
				c.gridx = 0;	c.gridy = 2;
				contentP.add(JLabelProjectAuthor, c);
				final JTextField JTextProjectAuthor = new JTextField(12);
				c.gridx = 1;	c.gridy = 2;
				contentP.add(JTextProjectAuthor, c);
				
				JLabel JLabelProjectNumber = new JLabel("Number Employe");
				c.gridx = 0;	c.gridy = 3;
				contentP.add(JLabelProjectNumber, c);
				final JTextField JTextProjectNumber = new JTextField(12);
				c.gridx = 1;	c.gridy = 3;
				contentP.add(JTextProjectNumber, c);
				
				JLabel JLabelProjectCompletion = new JLabel("Completion");
				c.gridx = 0;	c.gridy = 4;
				contentP.add(JLabelProjectCompletion, c);
				final JTextField JTextProjectCompletion = new JTextField(12);
				c.gridx = 1;	c.gridy = 4;
				contentP.add(JTextProjectCompletion, c);
				
				JButton submitTask = new JButton("Submit Task");
				c.gridx = 0;	c.gridy = 5;
				contentP.add(submitTask, c);
				
				
				
				submitTask.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
						String idS = (String) JComboBoxModify.getSelectedItem();
						int id = Integer.parseInt(idS);
						
						Project t = new Project();
						
						try
						{
							t.setName(JTextProjectName.getText());
							t.setAuthor(JTextProjectAuthor.getText());
							int number = Integer.parseInt(JTextProjectNumber.getText());
							int completion = Integer.parseInt(JTextProjectCompletion.getText());
							
							
							
							if(manager.modifyProject(id, t.getName(), t.getAuthor(), number, completion))
							{
								jLabelMessage.setText("Project : " + id + " Modified");
								newF.setVisible(false);
							}
							else
							{
								jLabelMessage.setText("Completion (0 - 100) and  Number Employe must be a Number");
							}
						}
						catch (Exception e)
						{
							
						}
					}
				});
				
			}
			else
			{
				final JdbcTaskDao manager = new JdbcTaskDao(connection);
				
				String[] idProject = manager.idParametre();
				
				
				final JDialog newF = new JDialog();
				newF.setVisible(true);
				newF.setTitle("Add Task");
				newF.setBounds(150, 150, 400, 300);
				
				JPanel contentT = new JPanel();
				
				newF.getContentPane().add(contentT, BorderLayout.CENTER);
				contentT.setLayout(new GridBagLayout());
				
				JLabel JLabelTaskSelection = new JLabel("Chose Your Project");
				c.gridx = 0;	c.gridy = 0;
				contentT.add(JLabelTaskSelection, c);
				JComboBoxModify = new JComboBox(idProject);
				c.gridx = 1;	c.gridy = 0;
				contentT.add(JComboBoxModify, c);
				
				JLabel JLabelTaskName = new JLabel("Name");
				c.gridx = 0;	c.gridy = 1;
				contentT.add(JLabelTaskName, c);
				final JTextField JTextTaskName = new JTextField(12);
				c.gridx = 1;	c.gridy = 1;
				contentT.add(JTextTaskName, c);
				
				JLabel JLabelTaskNumber = new JLabel("Number Employe");
				c.gridx = 0;	c.gridy = 3;
				contentT.add(JLabelTaskNumber, c);
				final JTextField JTextProjectNumber = new JTextField(12);
				c.gridx = 1;	c.gridy = 3;
				contentT.add(JTextProjectNumber, c);
				
				JLabel JLabelTaskCompletion = new JLabel("Completion");
				c.gridx = 0;	c.gridy = 4;
				contentT.add(JLabelTaskCompletion, c);
				final JTextField JTextTaskCompletion = new JTextField(12);
				c.gridx = 1;	c.gridy = 4;
				contentT.add(JTextTaskCompletion, c);
				
				JButton submitTask = new JButton("Submit Task");
				c.gridx = 0;	c.gridy = 5;
				contentT.add(submitTask, c);
				
				
				
				submitTask.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
						String idS = (String) JComboBoxModify.getSelectedItem();
						int id = Integer.parseInt(idS);
						
						Task t = new Task();
						
						try
						{
							t.setName(JTextTaskName.getText());
							int number = Integer.parseInt(JTextProjectNumber.getText());
							int completion = Integer.parseInt(JTextTaskCompletion.getText());
							
							
							
							if(manager.modifyTask(id, t.getName(), number, completion))
							{
								jLabelMessage.setText("Task : " + id + " Modified");
								newF.setVisible(false);
							}
							else
							{
								jLabelMessage.setText("Completion (0 - 100) and  Number Employe must be a Number");
							}
						}
						catch (Exception e)
						{
							
						}
					}
				});
			}
		}
	}
}