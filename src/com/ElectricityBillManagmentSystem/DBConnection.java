package com.ElectricityBillManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
	Connection c;
	Statement s;

	public DBConnection() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/Electricity_Bill_System";
			String dbUser = "JavaProjects";
			String dbPassword = "myPassword";
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			s = c.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
