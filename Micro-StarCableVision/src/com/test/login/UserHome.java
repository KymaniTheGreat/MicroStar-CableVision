package com.test.login;
import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class UserHome extends JFrame {
	private static final long serialID = 1L;
	private JPanel contpane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHome frame = new UserHome();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	UserHome(){
		
	}
	public UserHome(String users) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450,190,1014,597);
		setResizable(false);
		contpane = new JPanel();
		contpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contpane);
		contpane.setLayout(null);
		JButton btn2 = new JButton("Logout");
		btn2.setForeground(new Color(0, 0, 0));
		btn2.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 39));
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btn2, "ARE YOU SURE?");
				//JOptionPane.setRootFrame(null);
				if(a == JOptionPane.YES_OPTION) {
					dispose();
					LoginPage logobj = new LoginPage();
					logobj.setTitle("Customer-Login");
					logobj.setVisible(true);
				}
				dispose();
				LoginPage logobj = new LoginPage();
				logobj.setTitle("Customer-Login");
				logobj.setVisible(true);
				
						
			}
			
		});
		btn2.setBounds(247,118,491,114);
		contpane.add(btn2);
		JButton button = new JButton("Change-password\r\n");
		button.setBackground(UIManager.getColor("Button.disabledForground"));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangePassword newPwrd = new ChangePassword(users);
				newPwrd.setTitle("Change Password");
				newPwrd.setVisible(true)	;				
			}
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button.setBounds(247,320,491,114);
		contpane.add(button);
	
		
	}

}
