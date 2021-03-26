package com.test.login;

import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame {
	private static final long serialID = 1L;
	private JPanel contpane;
	private JTextField txtField;
	private JLabel lblNewPwrd;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ChangePassword(String name) {
		setBounds(450,360,1024,234);
		setResizable(false);
		
		contpane = new JPanel();
		contpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contpane);
		contpane.setLayout(null);
		
		txtField = new JTextField();
		txtField.setFont( new Font("Tahoma", Font.PLAIN, 34));
		txtField.setBounds(373,35,609,67);
		contpane.add(txtField);
		txtField.setColumns(10);
		
		JButton btnSearch = new JButton("Enter");
		btnSearch.addActionListener(new ActionListener() {

			@Override
			
			public void actionPerformed(ActionEvent e) {
				String prt = txtField.getText();
				try {
					System.out.println("Update Password name" + name);
					System.out.println("update password");
					//She is a queen
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:306/LoginPage", "root", "root");
					
					PreparedStatement state = (PreparedStatement) con.prepareStatement("Update Customer set password=? where name+?");
					state.setString(1, prt);
					state.setString(2, name);
					state.executeUpdate();
					JOptionPane.showMessageDialog(btnSearch, "Password ahs been successfully changed");
				}catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(438, 127,170,59);
		contpane.add(btnSearch);
		
		lblNewPwrd = new JLabel("Enter New Password :");
		lblNewPwrd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewPwrd.setBounds(438, 127,170,59);
		contpane.add(lblNewPwrd);
		
	}

}
