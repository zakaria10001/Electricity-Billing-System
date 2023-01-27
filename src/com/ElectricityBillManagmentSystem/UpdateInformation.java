package com.ElectricityBillManagmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateInformation extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JButton b1, b2;
	String meter;

	public UpdateInformation(String meter) {
		this.meter = meter;
		setBounds(500, 220, 500, 450);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel title = new JLabel("Update Customer Information");
		title.setBounds(110, 0, 400, 30);
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(title);

		l1 = new JLabel("Name");
		l1.setBounds(30, 70, 100, 20);

		l2 = new JLabel();
		l2.setBounds(230, 70, 200, 20);

		l3 = new JLabel("Meter Number");
		l3.setBounds(30, 110, 100, 20);

		l4 = new JLabel();
		l4.setBounds(230, 110, 200, 20);

		l5 = new JLabel("Address");
		l5.setBounds(30, 150, 100, 20);

		l6 = new JLabel("City");
		l6.setBounds(30, 190, 100, 20);

		l7 = new JLabel("State");
		l7.setBounds(30, 230, 100, 20);

		l8 = new JLabel("Email");
		l8.setBounds(30, 270, 100, 20);

		l9 = new JLabel("Phone");
		l9.setBounds(30, 310, 100, 20);

		tf1 = new JTextField();
		tf1.setBounds(230, 150, 200, 20);

		tf2 = new JTextField();
		tf2.setBounds(230, 190, 200, 20);

		tf3 = new JTextField();
		tf3.setBounds(230, 230, 200, 20);

		tf4 = new JTextField();
		tf4.setBounds(230, 270, 200, 20);

		tf5 = new JTextField();
		tf5.setBounds(230, 310, 200, 20);

		b1 = new JButton("Update");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70, 360, 100, 25);
		b1.addActionListener(this);

		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(230, 360, 100, 25);
		b2.addActionListener(this);

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(b1);
		add(b2);

		setResizable(false);
		try {
			DBConnection connection = new DBConnection();
			ResultSet rs = connection.s.executeQuery("select * from customer where meter = '" + meter + "'");
			while (rs.next()) {
				l2.setText(rs.getString(1));
				l4.setText(rs.getString(2));
				tf1.setText(rs.getString(3));
				tf2.setText(rs.getString(4));
				tf3.setText(rs.getString(5));
				tf4.setText(rs.getString(6));
				tf5.setText(rs.getString(7));
			}
		} catch (Exception e) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String s1 = l2.getText();
			String s2 = l4.getText();
			String s3 = tf1.getText();
			String s4 = tf2.getText();
			String s5 = tf3.getText();
			String s6 = tf4.getText();
			String s7 = tf5.getText();

			if (s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty())
				JOptionPane.showMessageDialog(null, "Please Fill In all The Fields ");
			else {

				try {
					DBConnection connection = new DBConnection();
					connection.s.executeUpdate("update customer set address = '" + s3 + "', city = '" + s4
							+ "', state = '" + s5 + "',email = '" + s6 + "', phone = '" + s7 + "'");
					JOptionPane.showMessageDialog(null, "Details Updated Successfully");
					this.setVisible(false);
				} catch (Exception e2) {

				}
			}
		} else if (e.getSource() == b2) {
			this.setVisible(false);
		}

	}

}
