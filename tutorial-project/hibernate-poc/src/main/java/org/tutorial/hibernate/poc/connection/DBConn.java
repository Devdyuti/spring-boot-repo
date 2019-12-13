package org.tutorial.hibernate.poc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		}catch (Exception e) {
			System.out.println("Connection couldn't established:: "+e);
		}
		return conn;
	}
}
