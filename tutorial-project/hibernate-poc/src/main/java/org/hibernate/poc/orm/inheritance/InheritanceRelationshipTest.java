package org.hibernate.poc.orm.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class InheritanceRelationshipTest {
	public static void main(String[] args) {
		Transaction tx=null;
		SessionFactory sf=null;
		Session session=null;
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			JavaStudent java=new JavaStudent(111, "Devdyuti", "683118", "7428766617", "SpringMVC");
			DotNetStudent dotnet=new DotNetStudent(222, "Rahul", "683115", "9891079366", 8.0);
			PhpStudent php=new PhpStudent(333, "Sunil", "683445", "9931600855", "automation");
			
			
			session.save(java);
			session.save(dotnet);
			session.save(php);
			
			
			tx.commit();
			
			System.out.println("Data Inserted Successfully!!");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	}
}
