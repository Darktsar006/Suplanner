package SuPlannerGui;

import java.awt.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import jdbcSupPlanner.*;

public class GUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jLabeLTitre = new JLabel("Sup Planner");
	
	private Connection connection;
	
	JLabel jLabelMessage = new JLabel("OK");
	
	List listE = new List();
	List listC = new List();
	
	JLabel JLabelEmail = new JLabel("Email : ");
	JTextField JTextEmail = new JTextField(12);
	JLabel JLabelPassword = new JLabel("Password : ");
	JTextField JTextPassword = new JTextField(12);
	
	JButton JButtonSubmit = new JButton("Submit");
	
	public GUI(Connection d)
	{
		connection = d;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setSize(700, 300);
		this.setTitle("Sup Planner B2");
		this.setBounds(10, 10, 700, 300);
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel panel2 = new JPanel();
		this.getContentPane().add(panel2, BorderLayout.SOUTH);
		panel2.setLayout(new GridBagLayout());
		
		JPanel panel3 = new JPanel();
		this.getContentPane().add(panel3, BorderLayout.CENTER);
		panel3.setLayout(new GridBagLayout());
		
		
		panel2.add(jLabelMessage);
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,0,0);
		panel3.add(JLabelEmail, c);
		
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(JTextEmail, c);
		
		c.gridx = 0;
		c.gridy = 1;
		panel3.add(JLabelPassword, c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel3.add(JTextPassword, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(20,0,0,0);
		panel3.add(JButtonSubmit, c);
		
		// Listener
		JButtonSubmit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == JButtonSubmit)
		{
			JdbcEmployeDao t = new JdbcEmployeDao(connection);
			String email = JTextEmail.getText();
			String password = JTextPassword.getText();
			
			this.validate();
			this.repaint();
			if(t.loginEmploye(email, password))
			{
				jLabelMessage.setText("Login successful");
			}
			else
			{
				jLabelMessage.setText("Login failed");
			}
		}
		
	}
}
