package org.tutorial.hibernate.poc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.cfg.Configuration;

public class TestOracleConn {
	
	private static Connection conn=null;
	private static ResultSet rs=null;
	private static PreparedStatement ps =null;
	
	
	public static void main(String[] args) {
		try {
			conn=DBConn.getConnection();
			ps=conn.prepareStatement("insert into TUTORIAL.USERX(ID_USER,USER_ADD,USER_AGE,USER_NAME) values(?,?,?,?)");
			ps.setInt(1, 1);
			ps.setString(2, "sector 168");
			ps.setInt(3, 23);
			ps.setString(4, "Devdyuti");
			ps.execute();
			System.out.println("Inserted Successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
