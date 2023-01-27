package com.ElectricityBillManagmentSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {
	JTable t;
	String meter;
	String x[] = { "Meter Number", "Month", "Units", "Total Bill", "Status" };
	String y[][] = new String[40][8];
	JScrollPane sp;
	int i = 0, j = 0;

	public BillDetails(String meter) {
		super("Bill Details");
		setSize(750, 650);
		setLocation(600, 150);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		t = new JTable(y, x);
		this.meter = meter;
		try {
			DBConnection connection = new DBConnection();
			String s1 = "select * from bill where meter = '" + meter + "'";
			ResultSet rs = connection.s.executeQuery(s1);
			t.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println("Error");
		}
		sp = new JScrollPane(t);
		sp.setBounds(0, 0, 750, 650);
		add(sp);
		setResizable(false);

	}

}
