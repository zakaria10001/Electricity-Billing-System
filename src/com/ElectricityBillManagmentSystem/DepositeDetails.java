package com.ElectricityBillManagmentSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class DepositeDetails extends JFrame implements ActionListener {

	JTable t;
	JButton b1, b2;
	JLabel l1, l2;
	Choice choice1, choice2;
	String x[] = { "Meter Number", "Month", "Units", "Total Bill", "Status" };
	String y[][] = new String[40][8];
	int i = 0, j = 0;

	public DepositeDetails() {
		super("Deposit Details");
		setSize(750, 750);
		setLocation(600, 150);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		l1 = new JLabel("sort by Meter Number ");
		l1.setBounds(20, 20, 170, 20);
		add(l1);
		l2 = new JLabel("sort by Month ");
		l2.setBounds(420, 20, 130, 20);
		add(l2);
		t = new JTable(y, x);
		choice1 = new Choice();
		choice2 = new Choice();
		try {
			DBConnection connection = new DBConnection();
			String str = "select * from bill";
			ResultSet rs = connection.s.executeQuery(str);
			t.setModel(DbUtils.resultSetToTableModel(rs));
			String str2 = "select * from customer";
			rs = connection.s.executeQuery(str2);
			while (rs.next()) {
				choice1.add(rs.getString("meter"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		choice1.setBounds(200, 20, 150, 20);
		choice2.setBounds(550, 20, 150, 20);
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
		add(choice1);
		add(choice2);

		b1 = new JButton("Search");
		b1.setBounds(20, 70, 100, 20);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Print");
		b2.setBounds(140, 70, 100, 20);
		b2.addActionListener(this);
		add(b2);

		JScrollPane sp = new JScrollPane(t);
		sp.setBounds(0, 100, 700, 650);
		add(sp);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String str = "select * from bill where meter = '" + choice1.getSelectedItem() + "' and month = '"
					+ choice2.getSelectedItem() + "'";
			try {
				DBConnection connection = new DBConnection();
				ResultSet rs = connection.s.executeQuery(str);
				t.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (Exception e2) {
				System.out.println("Error");
			}
		} else if (e.getSource() == b2) {
			try {
				t.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}

		}

	}

}
