package org.tutorial.hibernate.poc.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**This class no longer used, only APPLICABLE in case of XML based mapping.
 * **/
public class ConfigurationTest {
	public static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		}catch (Exception e) {
			System.out.println("Exception in configuration:: "+e);
		}
		return null;
	}
	public static void main(String[] args) {
		buildSessionFactory();
	}
}
