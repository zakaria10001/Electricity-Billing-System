package com.ElectricityBillManagmentSystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateBill extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField tf1;
	JButton b1, b2;
	JPanel p;
	Choice choice1, choice2;

	public CalculateBill() {

		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216, 230));

		l1 = new JLabel("Calculate Electricity Bill");
		l1.setBounds(30, 10, 400, 30);

		l2 = new JLabel("Meter No");
		l2.setBounds(60, 70, 100, 30);

		l3 = new JLabel("Name");
		l3.setBounds(60, 120, 100, 30);

		l4 = new JLabel("Address");
		l4.setBounds(60, 170, 100, 30);

		l5 = new JLabel("Units Cunsomed");
		l5.setBounds(60, 220, 130, 30);

		l6 = new JLabel("Month");
		l6.setBounds(60, 270, 100, 20);

		choice1 = new Choice();
		choice1.setBounds(200, 75, 100, 20);

		try {
			DBConnection connection = new DBConnection();
			ResultSet rs = connection.s.executeQuery("select * from customer");
			while (rs.next()) {
				choice1.add(rs.getString("meter"));

			}

		} catch (Exception e) {
		}

		l7 = new JLabel();
		l7.setBounds(200, 125, 180, 20);

		l8 = new JLabel();
		l8.setBounds(200, 175, 180, 20);

		try {
			DBConnection connection = new DBConnection();
			ResultSet rs = connection.s
					.executeQuery("select * from customer where meter = '" + choice1.getSelectedItem() + "'");
			while (rs.next()) {
				l7.setText(rs.getString("name"));
				l8.setText(rs.getString("address"));

			}

		} catch (Exception e) {
		}

		choice1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ae) {
				try {
					DBConnection connection = new DBConnection();
					ResultSet rs = connection.s
							.executeQuery("select * from customer where meter = '" + choice1.getSelectedItem() + "'");
					while (rs.next()) {
						l7.setText(rs.getString("name"));
						l8.setText(rs.getString("address"));

					}

				} catch (Exception e) {
				}

			}
		});
		tf1 = new JTextField();
		tf1.setBounds(200, 225, 180, 20);

		choice2 = new Choice();
		choice2.setBounds(200, 275, 180, 20);
		choice2.add("January");
		choice2.add("February");
		choice2.add("March");
		choice2.add("April");
		choice2.add("May");
		choice2.add("June");
		choice2.add("July");
		choice2.add("August");
		choice2.add("September");
		choice2.add("October");
		choice2.add("Novomber");
		choice2.add("December");

		b1 = new JButton("Submit");
		b1.setBounds(100, 350, 100, 25);
		b2 = new JButton("Cancel");
		b2.setBounds(230, 350, 100, 25);

		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		l9 = new JLabel();

		l1.setFont(new Font("Sanserif", Font.PLAIN, 26));

		b1.addActionListener(this);
		b2.addActionListener(this);

		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l8);
		p.add(l9);
		p.add(choice1);
		p.add(tf1);
		p.add(choice2);
		p.add(b1);
		p.add(b2);

		setLayout(new BorderLayout(30, 30));
		add(p, "Center");

		getContentPane().setBackground(Color.WHITE);

		setSize(500, 500);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String meter_no = choice1.getSelectedItem();
			String units = tf1.getText();
			String month = choice2.getSelectedItem();

			double unitsCunsomed = Double.parseDouble(units);
			double totalBill = 0;
			try {
				DBConnection connection = new DBConnection();
				ResultSet rs = connection.s.executeQuery("select * from tax");
				while (rs.next()) {
					totalBill = unitsCunsomed * Double.parseDouble(rs.getString("cost_per_unit"));
					totalBill += Double.parseDouble("meter_rent");
					totalBill += Double.parseDouble("service_charge");
					totalBill += Double.parseDouble("servive_tax");
					totalBill += Double.parseDouble("fixed_tax");

				}
			} catch (Exception e2) {
			}

			String q = "insert into bill values ('" + meter_no + "','" + month + "','" + units + "','" + totalBill
					+ "','Not Paid')";
			try {
				DBConnection connection = new DBConnection();
				connection.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
				this.setVisible(false);

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} else if (e.getSource() == b2) {
			this.setVisible(false);

		}

	}
}
