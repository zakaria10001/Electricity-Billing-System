package com.ElectricityBillManagmentSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewInformation extends JFrame implements ActionListener {
	JButton b;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, title;

	public ViewInformation(String meter) {

		setBounds(600, 250, 600, 650);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		title = new JLabel("View Customer Information");
		title.setBounds(175, 0, 500, 40);
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));

		l1 = new JLabel("Name");
		l1.setBounds(70, 80, 150, 20);

		l2 = new JLabel("Meter Number");
		l2.setBounds(70, 140, 150, 20);

		l3 = new JLabel("Address");
		l3.setBounds(70, 200, 150, 20);

		l4 = new JLabel("City");
		l4.setBounds(70, 260, 150, 20);

		l5 = new JLabel("State");
		l5.setBounds(70, 320, 150, 20);

		l6 = new JLabel("Email");
		l6.setBounds(70, 380, 150, 20);

		l7 = new JLabel("Phone");
		l7.setBounds(70, 440, 150, 20);

		l8 = new JLabel();
		l8.setBounds(250, 80, 100, 20);

		l9 = new JLabel();
		l9.setBounds(250, 140, 100, 20);

		l10 = new JLabel();
		l10.setBounds(250, 200, 100, 20);

		l11 = new JLabel();
		l11.setBounds(250, 260, 100, 20);

		l12 = new JLabel();
		l12.setBounds(250, 320, 100, 20);

		l13 = new JLabel();
		l13.setBounds(250, 380, 100, 20);

		l14 = new JLabel();
		l14.setBounds(250, 440, 100, 20);

		try {
			DBConnection connection = new DBConnection();
			ResultSet rs = connection.s.executeQuery("select * from customer where meter = '" + meter + "'");
			while (rs.next()) {
				l8.setText(rs.getString(1));
				l9.setText(rs.getString(2));
				l10.setText(rs.getString(3));
				l11.setText(rs.getString(4));
				l12.setText(rs.getString(5));
				l13.setText(rs.getString(6));
				l14.setText(rs.getString(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		b = new JButton("Back");
		b.setBounds(260, 500, 100, 25);
		b.setBackground(Color.black);
		b.setForeground(Color.WHITE);
		b.addActionListener(this);
		add(b);

		add(title);
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
		add(l12);
		add(l13);
		add(l14);

		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);

	}

}
