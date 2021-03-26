package com.test.login;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage extends JFrame {
	private static final long serialID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btn;
	private JLabel label;
	private JPanel contpane;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage ();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		// Queen 
	});
	}
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contpane = new JPanel();
		contpane.setBorder(new EmptyBorder(5,5,5,5));
		contpane.setLayout(null);
		
		JLabel label = new JLabel("Login");
		label.setForeground(Color.black);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		label.setBounds(423,13,273,93);
		contpane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(481,170,281,68);
		contpane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481,170,281,68);
		contpane.add(passwordField);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setForeground(Color.BLACK);
		labelPassword.setBackground(Color.CYAN);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		labelPassword.setBounds(250,286,193,52);
		contpane.add(labelPassword);
		
		btn = new JButton("Login");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn.setBounds(545,392,162,73);
		btn.addActionListener(new ActionListener() {
			
	public void actionPerformed(ActionEvent e) {
		String id = textField.getText();
		String password = passwordField.getText();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc: mysql://localhost:3306/LoginPage", "root", "root");
			PreparedStatement state = (PreparedStatement) connection.prepareStatement("Select id, password from users where id =? and password =?");
					
			state.setString(1, id);
			state.setString(2, password);
			ResultSet rset = state.executeQuery();
			if (rset.next()) {
				dispose();
				UserHome ah = new UserHome(id);
				ah.setTitle("Welcome");
				ah.setVisible(true);
				JOptionPane.showMessageDialog(btn, "You have successfully logged in");
				}else {
				JOptionPane.showMessageDialog(btn, "Wrong ID & Password");		
				}
			}catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		}
	});
		
		contpane.add(btn);
		label = new JLabel("");
		label.setBounds(0,0,1008,562);
		contpane.add(label);
	}
	}
		

