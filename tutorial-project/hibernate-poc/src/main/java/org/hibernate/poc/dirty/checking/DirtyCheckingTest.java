package org.hibernate.poc.dirty.checking;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.autoddl.Employee;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class DirtyCheckingTest {
	public static void main(String[] args) {
		Transaction tx=null;
		Session session=null;
		SessionFactory sf=null;
	
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			Employee e=(Employee)session.load(Employee.class, 81);// name=Rakesh;
			e.setName("Devdyuti singh");
			tx.commit(); // Name of employee updated without calling the update(). Hibernate automatically updated the persisted object within transaction boundary.
			
		}catch (Exception e) {
			System.out.println("Exception in DirtyCheckingClass: "+e);
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
		
	}
}
