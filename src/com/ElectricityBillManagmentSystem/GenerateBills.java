package com.ElectricityBillManagmentSystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GenerateBills extends JFrame implements ActionListener {
	String meter;
	JLabel l1, l2;
	JTextArea ta;
	JButton b;
	Choice choice;
	JPanel p;

	public GenerateBills(String meter) {
		this.meter = meter;
		setSize(500, 700);
		setLayout(new BorderLayout());

		p = new JPanel();
		l1 = new JLabel("Generate Bill");
		l2 = new JLabel(meter);
		choice = new Choice();
		choice.add("January");
		choice.add("February");
		choice.add("March");
		choice.add("April");
		choice.add("May");
		choice.add("June");
		choice.add("July");
		choice.add("August");
		choice.add("September");
		choice.add("October");
		choice.add("November");
		choice.add("December");

		ta = new JTextArea(45, 15);
		ta.setText(
				"\n\n\t------- Click on the -------\n\t Generate Bill button to get\n\t the bill of the selected month\n\n");
		JScrollPane sp = new JScrollPane(ta);
		ta.setFont(new Font("Sanserif", Font.ITALIC, 10));

		b = new JButton("Generate Bill");

		p.add(l1);
		p.add(l2);
		p.add(ta);
		add(sp, "Center");
		add(p, "North");
		add(b, "South");
		b.addActionListener(this);
		setLocation(750, 100);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			DBConnection connection = new DBConnection();
			String month = choice.getSelectedItem();
			ta.setText("\t Reliance Power Limited\n ELECTRICITE BILL FOR THE MONTH OF " + month + " ,2023\n\n\n");
			ResultSet rs = connection.s.executeQuery("select * from customer where meter = '" + meter + "'");
			if (rs.next()) {
				ta.append("\n   Customer Name : " + rs.getString("name"));
				ta.append("\n   Meter Number : " + rs.getString("meter"));
				ta.append("\n   Address : " + rs.getString("address"));
				ta.append("\n   State : " + rs.getString("state"));
				ta.append("\n   City : " + rs.getString("city"));
				ta.append("\n   Email : " + rs.getString("email"));
				ta.append("\n   Phone Number : " + rs.getString("phone"));
				ta.append("\n--------------------------------------------\n");
			}
			rs = connection.s.executeQuery("select * from meter_info where meter_number = '" + meter + "'");
			if (rs.next()) {

				ta.append("\n   Meter Location : " + rs.getString("meter_location"));
				ta.append("\n   Meter Type : " + rs.getString("meter_type"));
				ta.append("\n   Phase Code : " + rs.getString("phase_code"));
				ta.append("\n   Bill Type : " + rs.getString("bill_type"));
				ta.append("\n   Days : " + rs.getString("days"));
				ta.append("\n--------------------------------------------\n");

			}
			rs = connection.s.executeQuery("select * from tax");
			if (rs.next()) {

				ta.append("\n   Cost per Unit : " + rs.getString("cost_per_unit"));
				ta.append("\n   Meter Rent : " + rs.getString("meter_rent"));
				ta.append("\n   Service Charge : " + rs.getString("service_charge"));
				ta.append("\n   Service Tax : " + rs.getString("service_tax"));
				ta.append("\n   Fixed Tax : " + rs.getString("fixed_tax"));
				ta.append("\n--------------------------------------------\n");

			}
			rs = connection.s
					.executeQuery("select * from bill where meter ='" + meter + "' and month = '" + month + "'");
			if (rs.next()) {

				ta.append("\n   Current Month : " + rs.getString("month"));
				ta.append("\n   Unit Cunsomed : " + rs.getString("units"));
				ta.append("\n   Total Charges : " + rs.getString("total_bill"));
				ta.append("\n--------------------------------------------\n");
				ta.append("\n   TOTAL PAYABLE : " + rs.getString("total_bill"));

			}

		} catch (Exception e2) {
			// TODO: handle exception
		}

	}
}
