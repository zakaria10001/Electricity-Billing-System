package com.ElectricityBillManagmentSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class NewCustomer extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JButton b1, b2;

	public NewCustomer() {
		setLocation(600, 200);
		setSize(700, 500);
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.white);
		p.setBackground(new Color(173, 216, 230));
		JLabel title = new JLabel("New Customer");
		title.setBounds(180, 10, 200, 26);
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		p.add(title);

		l1 = new JLabel("Customer Name");
		l1.setBounds(100, 80, 150, 20);
		l2 = new JLabel("Meter No");
		l2.setBounds(100, 120, 150, 20);
		l = new JLabel();
		l.setBounds(250, 120, 200, 20);
		l3 = new JLabel("Address");
		l3.setBounds(100, 160, 150, 20);
		l5 = new JLabel("City");
		l5.setBounds(100, 200, 150, 20);
		l4 = new JLabel("State");
		l4.setBounds(100, 240, 150, 20);
		l6 = new JLabel("Email");
		l6.setBounds(100, 280, 150, 20);
		l7 = new JLabel("Phone Number");
		l7.setBounds(100, 320, 150, 20);
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l);

		tf1 = new JTextField();
		tf1.setBounds(250, 80, 200, 20);
		tf3 = new JTextField();
		tf3.setBounds(250, 160, 200, 20);
		tf4 = new JTextField();
		tf4.setBounds(250, 200, 200, 20);
		tf5 = new JTextField();
		tf5.setBounds(250, 240, 200, 20);
		tf6 = new JTextField();
		tf6.setBounds(250, 280, 200, 20);
		tf7 = new JTextField();
		tf7.setBounds(250, 320, 200, 20);
		p.add(tf1);
		p.add(tf3);
		p.add(tf4);
		p.add(tf5);
		p.add(tf6);
		p.add(tf7);

		b1 = new JButton("Next");
		b1.setBounds(310, 390, 100, 25);
		b2 = new JButton("Cancel");
		b2.setBounds(140, 390, 100, 25);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p.add(b1);
		p.add(b2);
		setLayout(new BorderLayout());

		add(p, "Center");

		getContentPane().setBackground(Color.WHITE);
		b1.addActionListener(this);
		b2.addActionListener(this);

		Random random = new Random();
		long first = (random.nextLong() % 1000000);
		l.setText("" + Math.abs(first));

		setVisible(false);
		setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String name = tf1.getText();
			String meter = l.getText();
			String address = tf3.getText();
			String city = tf4.getText();
			String state = tf5.getText();
			String email = tf6.getText();
			String phone = tf7.getText();

			if (name.isEmpty() || meter.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty()
					|| email.isEmpty() || phone.isEmpty())
				JOptionPane.showMessageDialog(null, "Please Fill in all the fields!");
			else {

				String q1 = "insert into customer values('" + name + "','" + meter + "','" + address + "','" + city
						+ "','" + state + "','" + email + "','" + phone + "')";
				String q2 = "insert into login values('" + meter + "','','','','')";

				try {
					DBConnection connection = new DBConnection();
					connection.s.executeUpdate(q1);
					connection.s.executeUpdate(q2);
					JOptionPane.showMessageDialog(null, "Customer Details added succussfully");
					this.setVisible(false);
					new MeterInfo(meter).setVisible(true);
				} catch (Exception e1) {
					System.out.println("Error");
				}

			}
		} else if (e.getSource() == b2) {
			this.setVisible(false);

		}

	}

}
