package com.ElectricityBillManagmentSystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MeterInfo extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	Choice choice1, choice2, choice3, choice4, choice5;
	JButton b1, b2;
	JPanel p;

	public MeterInfo(String meter) {
		setSize(700, 500);
		setLocation(600, 200);

		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216, 230));

		JLabel title = new JLabel("Meter Information");
		title.setBounds(180, 10, 250, 26);
		title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(title);

		l1 = new JLabel("Meter Number");
		l1.setBounds(100, 80, 110, 20);
		l11 = new JLabel(meter);
		l11.setBounds(240, 80, 200, 20);
		l2 = new JLabel("Meter Location");
		l2.setBounds(100, 120, 110, 20);
		choice1 = new Choice();
		choice1.add("Outside");
		choice1.add("Inside");
		choice1.setBounds(240, 120, 200, 20);

		l3 = new JLabel("Meter Type");
		l3.setBounds(100, 160, 110, 20);
		choice2 = new Choice();
		choice2.add("Electric Meter");
		choice2.add("Solar Meter");
		choice2.add("Smart Meter");
		choice2.setBounds(240, 160, 200, 20);

		l5 = new JLabel("Phase Code");
		l5.setBounds(100, 200, 110, 20);
		choice3 = new Choice();
		choice3.add("011");
		choice3.add("022");
		choice3.add("033");
		choice3.add("044");
		choice3.add("055");
		choice3.add("066");
		choice3.add("077");
		choice3.add("088");
		choice3.add("099");
		choice3.setBounds(240, 200, 200, 20);

		l4 = new JLabel("Bill Type");
		l4.setBounds(100, 240, 110, 20);
		choice4 = new Choice();
		choice4.add("Normal");
		choice4.add("Industrial");
		choice4.setBounds(240, 240, 200, 20);

		l6 = new JLabel("Days");
		l6.setBounds(100, 280, 110, 20);
		l9 = new JLabel("30 Days");
		l9.setBounds(240, 280, 200, 20);

		l7 = new JLabel("Note");
		l7.setBounds(100, 320, 110, 20);

		l10 = new JLabel("By Defalt Bill Calculated for 30 days only");
		l10.setBounds(240, 320, 300, 20);

		b1 = new JButton("Submit");
		b1.setBounds(120, 390, 100, 25);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("Cancel");
		b2.setBounds(250, 390, 100, 25);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		p.add(l1);
		p.add(l2);
		p.add(l11);
		p.add(choice1);
		p.add(l3);
		p.add(choice2);
		p.add(l5);
		p.add(choice3);
		p.add(l4);
		p.add(choice4);
		p.add(l6);
		p.add(l7);
		p.add(l9);
		p.add(l10);
		p.add(b1);
		p.add(b2);

		setLayout(new BorderLayout());
		setResizable(false);

		add(p, "Center");

		getContentPane().setBackground(Color.WHITE);

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String meter_number = l11.getText();
			String meter_location = choice1.getSelectedItem();
			String meter_type = choice2.getSelectedItem();
			String phase_code = choice3.getSelectedItem();
			String bill_type = choice4.getSelectedItem();
			String days = "30";

			String q1 = "insert into meter_info values ('" + meter_number + "','" + meter_location + "','" + meter_type
					+ "','" + phase_code + "','" + bill_type + "','" + days + "')";

			try {
				DBConnection connection = new DBConnection();
				connection.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Meter info has been added successfully");
				this.setVisible(false);
			} catch (Exception e1) {
				System.out.println("Error");
			}
		} else if (e.getSource() == b2) {
			this.setVisible(false);

		}
	}

}
