package com.ElectricityBillManagmentSystem;

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
import javax.swing.JTextField;

public class PayBill extends JFrame implements ActionListener {
	String meter;
	JLabel title, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	JButton b1, b2;
	Choice choice1, choice2;
	JTextField tf1;

	public PayBill(String meter) {
		this.meter = meter;
		setLayout(null);
		setBounds(550, 220, 450, 600);
		title = new JLabel("Electricity Bill");
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		title.setBounds(120, 5, 400, 30);
		add(title);

		l1 = new JLabel("Meter No");
		l1.setBounds(35, 80, 200, 20);
		l2 = new JLabel("Name");
		l2.setBounds(35, 140, 200, 20);

		l3 = new JLabel("Month");
		l3.setBounds(35, 200, 200, 20);

		l4 = new JLabel();
		l4.setBounds(300, 80, 200, 20);

		l5 = new JLabel();
		l5.setBounds(300, 140, 200, 20);

		choice1 = new Choice();
		choice1.setBounds(300, 200, 200, 20);
		choice1.add("January");
		choice1.add("February");
		choice1.add("March");
		choice1.add("April");
		choice1.add("May");
		choice1.add("June");
		choice1.add("July");
		choice1.add("August");
		choice1.add("September");
		choice1.add("October");
		choice1.add("Novomber");
		choice1.add("December");

		l6 = new JLabel("Units");
		l6.setBounds(35, 260, 200, 20);

		l7 = new JLabel();
		l7.setBounds(300, 260, 200, 20);

		l8 = new JLabel("Total Bill");
		l8.setBounds(35, 320, 200, 20);

		l9 = new JLabel();
		l9.setBounds(300, 320, 200, 20);

		l10 = new JLabel("Status");
		l10.setBounds(35, 380, 200, 20);

		l11 = new JLabel();
		l11.setBounds(300, 380, 200, 20);
		l11.setForeground(Color.red);

		setResizable(false);

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		try {
			DBConnection connection = new DBConnection();
			ResultSet rs = connection.s.executeQuery("select * from customer where meter = '" + meter + "'");
			while (rs.next()) {
				l4.setText(rs.getString("meter"));
				l5.setText(rs.getString("name"));
			}
			rs = connection.s.executeQuery("select * from bill where meter = '" + meter + "' and month = 'January'");
			while (rs.next()) {
				l7.setText(rs.getString("units"));
				l9.setText(rs.getString("total_bill"));
				l11.setText(rs.getString("status"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		choice1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ae) {
				try {
					DBConnection connection = new DBConnection();
					ResultSet rs = connection.s.executeQuery("select * from bill where meter = '" + meter
							+ "' and month = '" + choice1.getSelectedItem() + "'");
					while (rs.next()) {
						l7.setText(rs.getString("units"));
						l9.setText(rs.getString("total_bill"));
						l11.setText(rs.getString("status"));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});

		b1 = new JButton("Pay");
		b1.setBounds(100, 460, 100, 25);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("Back");
		b2.setBounds(230, 460, 100, 25);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		add(b1);
		add(b2);

		getContentPane().setBackground(Color.WHITE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				DBConnection connection = new DBConnection();
				connection.s.executeQuery("update bill status = 'Paid' where meter = '" + meter + "' and month = '"
						+ choice1.getSelectedItem() + "'");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			this.setVisible(false);

		} else if (e.getSource() == b2) {
			this.setVisible(false);
		}

	}

}
