package org.tutorial.jcr.data.migration;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class TestDataSource {
	
	private static DataSource dataSource;
	private static Connection conn;
	
	
	public static Connection getConnection() {
		try {
			InitialContext ctxt=new InitialContext();
			dataSource=(DataSource) ctxt.lookup("java:jboss/exported/jcr/RCDArchivedRepository");
		} catch (NamingException e) {
			System.out.println("Datasource not Initialized: "+e);
		}
		try {
			conn=dataSource.getConnection();
		}catch (SQLException e) {
			System.out.println("Connection not avlaible: "+e);
		}
		return conn;
	}

}
