package org.tutorial.hibernate.poc.connection;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CHibernateUtils {
	static SessionFactory factory;
	
	static {
		try {
		Configuration cfg=new Configuration();		
		cfg.configure();
		factory=cfg.buildSessionFactory();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
