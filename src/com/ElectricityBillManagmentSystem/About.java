package com.ElectricityBillManagmentSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class About extends JFrame implements ActionListener {

	JButton btn;
	JLabel l;
	Font f1, f2, f3;
	TextArea txt;
	String str;

	public About() {
		setLayout(null);
		btn = new JButton("exit");
		l = new JLabel();
		add(btn);
		btn.setBounds(200, 430, 120, 20);
		btn.addActionListener(this);

		f1 = new Font("RALEWAY", Font.BOLD, 180);
		setFont(f1);

		str = "                 About Project               \n"
				+ "\n Electricity billing management system is software-based application,"
				+ "developed in java programming language."
				+ "the project aims at serving the departement of electricity\n\n";

		txt = new TextArea(str, 10, 40, Scrollbar.VERTICAL);
		txt.setEditable(false);
		txt.setBounds(20, 100, 450, 300);
		add(txt);

		f2 = new Font("RALEWAY", Font.BOLD, 16);
		txt.setFont(f2);

		Container contentPane = this.getContentPane();
		txt = new TextArea();

		l = new JLabel("About Project");
		add(l);
		l.setBounds(170, 10, 180, 80);
		l.setForeground(Color.red);

		f3 = new Font("RALEWAY", Font.BOLD, 20);
		l.setFont(f3);

		setBounds(700, 220, 500, 550);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	
}
