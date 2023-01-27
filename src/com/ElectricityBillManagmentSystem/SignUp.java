package com.ElectricityBillManagmentSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SignUp extends JFrame implements ActionListener {

	JPanel p1;
	JTextField tf1, tf2, tf3, tf4;
	Choice choice;
	JButton b1, b2;

	public SignUp() {
		setBounds(600, 250, 700, 400);
		p1 = new JPanel();
		p1.setBounds(30, 30, 650, 300);
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
		p1.setForeground(new Color(34, 139, 34));
		p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create Account",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
		;
		add(p1);

		JLabel l1 = new JLabel("UserName");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(100, 50, 100, 20);
		p1.add(l1);

		tf1 = new JTextField();
		tf1.setBounds(260, 50, 150, 20);
		p1.add(tf1);

		JLabel l2 = new JLabel("Name");
		l2.setForeground(Color.DARK_GRAY);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(100, 100, 100, 20);
		p1.add(l2);

		tf2 = new JTextField();
		tf2.setBounds(260, 100, 150, 20);
		p1.add(tf2);

		JLabel l3 = new JLabel("Password");
		l3.setForeground(Color.DARK_GRAY);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(100, 150, 100, 20);
		p1.add(l3);

		tf3 = new JTextField();
		tf3.setBounds(260, 150, 150, 20);
		p1.add(tf3);

		JLabel l4 = new JLabel("Create account as");
		l4.setForeground(Color.DARK_GRAY);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(100, 200, 150, 20);
		p1.add(l4);

		tf4 = new JTextField();
		tf4.setBounds(260, 200, 150, 20);
		tf4.setVisible(false);
		p1.add(tf4);

		JLabel l5 = new JLabel("Meter number");
		l5.setForeground(Color.DARK_GRAY);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(100, 250, 150, 20);
		l5.setVisible(false);
		p1.add(l5);

		choice = new Choice();
		choice.add("Admin");
		choice.add("Customer");
		choice.setBounds(260, 200, 150, 20);
		p1.add(choice);

		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String user = choice.getSelectedItem();
				if (user.equals("Customer")) {
					l5.setVisible(true);
					tf4.setVisible(true);
				} else {
					l5.setVisible(false);
					tf4.setVisible(false);
				}

			}
		});

		b1 = new JButton("Create");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(140, 290, 120, 30);
		b1.addActionListener(this);
		p1.add(b1);

		b2 = new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(300, 290, 120, 30);
		b2.addActionListener(this);
		p1.add(b2);
		
		setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String username = tf1.getText();
			String name = tf2.getText();
			String password = tf3.getText();
			String user = choice.getSelectedItem();
			String meter = tf4.getText();
			if (username.isEmpty() || name.isEmpty() || password.isEmpty())
				JOptionPane.showMessageDialog(null, "Please enter your information!");
			else {

				try {
					DBConnection c = new DBConnection();
					String str = null;
					if (user.equals("Admin"))
						str = "insert into login values ('" + meter + "','" + username + "','" + name + "','" + password
								+ "','" + user + "')";
					if (user.equals("Customer"))
						str = "update login set username = '" + username + "',name = '" + name + "',password = '"
								+ password + "',user = '" + user + "' where meter_no = '" + tf4.getText() + "'";
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Account created successfuly");
					this.setVisible(false);
					new Login().setVisible(true);

				} catch (Exception e1) {
					System.out.println("Error storing data into database");
				}
			}

		} else if (e.getSource() == b2) {
			this.setVisible(false);
			new Login().setVisible(true);

		}

	}
	
}
