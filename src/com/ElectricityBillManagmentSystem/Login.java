package com.ElectricityBillManagmentSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4;
	JTextField tf1;
	JPasswordField pf1;
	JButton b1, b2, b3;
	JPanel p1, p2, p3, p4;
	Choice choice;

	public Login() {
		super("Login Page");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		l1 = new JLabel("UserName");
		l2 = new JLabel("Password");
		l3 = new JLabel();
		l4 = new JLabel("Logging in as ");

		l1.setBounds(100, 20, 100, 20);
		l2.setBounds(100, 60, 100, 20);
		l4.setBounds(100, 100, 100, 20);
		add(l1);
		add(l2);
		add(l4);

		tf1 = new JTextField(15);
		tf1.setBounds(200, 20, 150, 20);
		add(tf1);

		pf1 = new JPasswordField(15);
		pf1.setBounds(200, 60, 150, 20);
		add(pf1);

		choice = new Choice();
		choice.add("Admin");
		choice.add("Customer");
		choice.setBounds(200, 100, 150, 20);
		add(choice);

		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpeg"));
		Image img1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		b1 = new JButton("Login", new ImageIcon(img1));
		b1.setBounds(130, 160, 100, 20);
		add(b1);

		ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
		Image img2 = ic2.getImage().getScaledInstance(13, 13, Image.SCALE_DEFAULT);
		b2 = new JButton("Cancel", new ImageIcon(img2));
		b2.setBounds(250, 160, 100, 20);
		add(b2);

		ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.jpeg"));
		Image img4 = ic4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		b3 = new JButton("SignUp", new ImageIcon(img4));
		b3.setBounds(190, 200, 120, 20);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		setLayout(new BorderLayout());
		setSize(450, 300);
		setLocation(600, 300);
		setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			try {
				DBConnection c = new DBConnection();
				String meter;
				String a = tf1.getText();
				String b = pf1.getText();
				String user = choice.getSelectedItem();
				String q = "select * from login where user = '" + a + "' and password = '" + b + "' and user = '" + user
						+ "'";
				ResultSet rs = c.s.executeQuery(q);
				if (rs.next()) {
					meter = rs.getString("meter_no");
					new Project(meter, user).setVisible(true);
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "invalid login!");
					tf1.setText("");
					pf1.setText("");
				}

			} catch (SQLException e1) {
				System.out.println("Error");
			}

		} else if (e.getSource() == b2) {
			this.setVisible(false);

		} else if (e.getSource() == b3) {
			this.setVisible(false);
			new SignUp().setVisible(true);

		}

	}

	public static void main(String[] args) {
		new Login().setVisible(true);

	}

}
