package org.tutorial.hibernate.poc.autoddl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class AutoDDLSupportTest {


	public static void main(String[] args) {
		Transaction tx=null;
		Session session=null;
		SessionFactory sf=null;
		

		
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			
			
				// Adding object using save, persist or saveOrUpdate methods
				Employee emp=new Employee("Devdyu","kjfd@gmail.com");

				Integer i=(Integer) session.save(emp);
				tx.commit();
				//Deattached state
				session.evict(emp);
				if(i!=null) {
					System.out.println("Record Inserted Successfully!!");
				}else {
					System.out.println("Duplicate value found");
				}
			
			


			
		}catch (Exception e) {
			System.out.println("Exception in AuoDDLSupport:: "+e);
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
		
	}
}
