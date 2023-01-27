package com.ElectricityBillManagmentSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerDetails extends JFrame implements ActionListener {

	JTable t;
	JButton b;
	String x[] = { "Customer Name", "Meter Number", "Address", "City", "State", "Email", "Phone" };
	String y[][] = new String[40][8];
	int i = 0, j = 0;

	public CustomerDetails() {
		super("Customer Details");
		setSize(1200, 650);
		setLocation(400, 150);
		try {
			DBConnection connection = new DBConnection();
			String str = "select * from customer";
			ResultSet rs = connection.s.executeQuery(str);
			while (rs.next()) {
				y[i][j++] = rs.getString("name");
				y[i][j++] = rs.getString("meter");
				y[i][j++] = rs.getString("address");
				y[i][j++] = rs.getString("city");
				y[i][j++] = rs.getString("city");
				y[i][j++] = rs.getString("state");
				y[i][j++] = rs.getString("email");
				y[i][j++] = rs.getString("phone");
				i++;
				j = 0;
			}
			t = new JTable(y, x);
		} catch (Exception e) {
			System.out.println("Error");
		}
		b = new JButton("Print");
		add(b, "South");
		JScrollPane sp = new JScrollPane(t);
		add(sp);
		b.addActionListener(this);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			t.print();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

}
