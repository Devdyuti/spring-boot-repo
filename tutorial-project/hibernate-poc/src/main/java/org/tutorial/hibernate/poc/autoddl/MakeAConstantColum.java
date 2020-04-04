package org.tutorial.hibernate.poc.autoddl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class MakeAConstantColum {
	public static void main(String[] args) {

		Transaction tx=null;
		Session session=null;
		SessionFactory sf=null;
		

		
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
//			Devdyuti d1=new Devdyuti(1, "Devdyuti",33, "Devraj singh");
//			Devdyuti d2=new Devdyuti(2, "Ravi",29, "Mitlesh singh");
//			
//			session.save(d1);
//			session.save(d2);
			
			Devdyuti d=(Devdyuti)session.load(Devdyuti.class, 167);
			d.setName("Dyuti");
			
			session.update(d);
			
			tx.commit();

			
		}catch (Exception e) {
			System.out.println("Exception in MakeAConstantColum:: "+e);
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
		
	
	}
}
