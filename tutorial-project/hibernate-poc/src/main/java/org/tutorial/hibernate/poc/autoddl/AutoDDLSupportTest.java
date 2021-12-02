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
//				Employee emp=new Employee("Devdyuti","dev@gmail.com",3000);

				Employee[] employees= {
						new Employee("Malani","malani@gmail.com",3000),
						new Employee("Shyam","shyam@gmail.com",2000),
						new Employee("Anil","anil@gmail.com",5000),
						new Employee("Yogesh","yogesh@gmail.com",5000),
						new Employee("Arun","arun@gmail.com",1000),
						new Employee("chinu","chinty@gmail.com",1500),
						new Employee("kamat","kamat@gmail.com",500),
						new Employee("banti","banti@gmail.com",500),
						new Employee("Raju","raju@gmail.com",3000)
				};
				
				Integer i=0;
				for(Employee emp : employees) {
					i=(Integer) session.save(emp);					
				}
				

				tx.commit();
				//Deattached state
//				session.evict(emp);
				if(i!=null) {
					System.out.println("Record Inserted Successfully!!");
				}else {
					System.out.println("Duplicate value found");
				}
			
			


			
		}catch (Exception e) {
			System.out.println("Exception in AuoDDLSupport:: "+e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
		
	}
}
