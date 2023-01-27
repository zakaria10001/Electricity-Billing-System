package com.ElectricityBillManagmentSystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Project extends JFrame implements ActionListener {
	String meter;

	public Project(String meter, String person) {
		super("Electricity Billing System");
		this.meter = meter;
		setSize(1000, 700);

		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/elecSt.jpg"));
		Image img1 = ic1.getImage().getScaledInstance(1010, 710, Image.SCALE_DEFAULT);
		ImageIcon ic2 = new ImageIcon(img1);
		JLabel l1 = new JLabel(ic2);
		add(l1);

		JMenuBar mb = new JMenuBar();
		JMenu master = new JMenu("Master");
		JMenuItem m1 = new JMenuItem("New Customer");
		JMenuItem m2 = new JMenuItem("Customer Details");
		JMenuItem m3 = new JMenuItem("Deposit Details");
		JMenuItem m4 = new JMenuItem("Calculate Bill");
		master.setForeground(Color.blue);

		m1.setFont(new Font("monospaced", Font.PLAIN, 12));
		m1.setMnemonic('D');
		m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		m1.setBackground(Color.WHITE);

		m2.setFont(new Font("monospaced", Font.PLAIN, 12));
		m2.setMnemonic('M');
		m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		m2.setBackground(Color.WHITE);

		m3.setFont(new Font("monospaced", Font.PLAIN, 12));
		m3.setMnemonic('N');
		m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		m3.setBackground(Color.WHITE);

		m4.setFont(new Font("monospaced", Font.PLAIN, 12));
		m4.setMnemonic('B');
		m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		m4.setBackground(Color.WHITE);

		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);

		JMenu info = new JMenu("Information");
		JMenuItem info1 = new JMenuItem("Update information");
		JMenuItem info2 = new JMenuItem("View information");

		info.setForeground(Color.red);

		info1.setFont(new Font("monospaced", Font.PLAIN, 12));
		info1.setMnemonic('P');
		info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		info1.setBackground(Color.WHITE);

		info2.setFont(new Font("monospaced", Font.PLAIN, 12));
		info2.setMnemonic('L');
		info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		info2.setBackground(Color.WHITE);

		info1.addActionListener(this);
		info2.addActionListener(this);

		JMenu user = new JMenu("User");
		JMenuItem u1 = new JMenuItem("Pay Bill");
		JMenuItem u3 = new JMenuItem("Bill Details");
		user.setForeground(Color.red);

		u1.setFont(new Font("monospaced", Font.PLAIN, 12));
		u1.setMnemonic('P');
		u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		u1.setBackground(Color.WHITE);

		u3.setFont(new Font("monospaced", Font.PLAIN, 12));
		u3.setMnemonic('L');
		u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		u3.setBackground(Color.WHITE);

		u1.addActionListener(this);
		u3.addActionListener(this);

		JMenu report = new JMenu("Report");
		JMenuItem r1 = new JMenuItem("Generate Bill");
		user.setForeground(Color.red);

		r1.setFont(new Font("monospaced", Font.PLAIN, 12));
		r1.setMnemonic('P');
		r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		r1.setBackground(Color.WHITE);

		r1.addActionListener(this);

		JMenu utility = new JMenu("Utility");
		JMenuItem ut1 = new JMenuItem("Notepad");
		JMenuItem ut2 = new JMenuItem("Calculator");
		JMenuItem ut3 = new JMenuItem("Web-Browser");
		user.setForeground(Color.red);

		ut1.setFont(new Font("monospaced", Font.PLAIN, 12));
		ut1.setMnemonic('C');
		ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		ut1.setBackground(Color.WHITE);

		ut2.setFont(new Font("monospaced", Font.PLAIN, 12));
		ut2.setMnemonic('X');
		ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		ut2.setBackground(Color.WHITE);

		ut3.setFont(new Font("monospaced", Font.PLAIN, 12));
		ut3.setMnemonic('W');
		ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		ut3.setBackground(Color.WHITE);

		ut1.addActionListener(this);
		ut2.addActionListener(this);
		ut3.addActionListener(this);

		JMenu exit = new JMenu("Logout");
		JMenuItem ex = new JMenuItem("Logout");
		user.setForeground(Color.red);

		ex.setFont(new Font("monospaced", Font.PLAIN, 12));
		ex.setMnemonic('Z');
		ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		ex.setBackground(Color.WHITE);

		ex.addActionListener(this);

		master.add(m1);
		master.add(m2);
		master.add(m3);
		master.add(m4);
		info.add(info1);
		info.add(info2);
		user.add(u1);
		user.add(u3);
		report.add(r1);
		utility.add(ut1);
		utility.add(ut2);
		utility.add(ut3);
		exit.add(ex);

		if (user.equals("Admin"))
			mb.add(master);
		else {
			mb.add(info);
			mb.add(user);
			mb.add(report);
		}
		mb.add(utility);
		mb.add(exit);
		setJMenuBar(mb);
		setFont(new Font("Senserif", Font.BOLD, 16));
		setLayout(new FlowLayout());
		setVisible(false);
		setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if (msg.equals("Customer Details"))
			new CustomerDetails().setVisible(true);
		else if (msg.equals("New Customer"))
			new NewCustomer().setVisible(true);
		else if (msg.equals("Deposit Details"))
			new DepositeDetails().setVisible(true);
		else if (msg.equals("Calculate Bill"))
			new CalculateBill().setVisible(true);
		else if (msg.equals("Pay Bill"))
			new PayBill(meter).setVisible(true);
		else if (msg.equals("Notepad"))
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e2) {
				System.out.println("can't open the notepad now!");
			}
		else if (msg.equals("Calculator"))
			try {
				Runtime.getRuntime().exec("Calc.exe");
			} catch (Exception e2) {
				System.out.println("can't open the calculator now!");
			}
		else if (msg.equals("Web-Browser"))
			try {
				Runtime.getRuntime().exec("~\\msedge.exe");
			} catch (Exception e2) {
				System.out.println("can't open the web browser now!");
			}
		else if (msg.equals("Logout")) {
			this.setVisible(false);
			new Login().setVisible(true);
		} else if (msg.equals("Generate Bill"))
			new GenerateBills(meter).setVisible(true);
		else if (msg.equals("View information"))
			new ViewInformation(meter).setVisible(true);
		else if (msg.equals("Update information"))
			new UpdateInformation(meter).setVisible(true);
		else if (msg.equals("Bill Details"))
			new BillDetails(meter).setVisible(true);

	}

}
