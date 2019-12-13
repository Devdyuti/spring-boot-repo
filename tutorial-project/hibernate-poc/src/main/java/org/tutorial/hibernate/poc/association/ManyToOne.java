package org.tutorial.hibernate.poc.association;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class ManyToOne {
	public static void main(String[] args) {
		Transaction tx=null;
		SessionFactory sf=null;
		Session session=null;
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			List<PGStudent> list_student=new ArrayList<PGStudent>();
			PGStudent s1=new PGStudent(1, "Devdyuti");
			PGStudent s2=new PGStudent(2, "Ramesh");
			list_student.add(s1);
			list_student.add(s2);
			
			Address address=new Address(1, "Ganga Nagar Hostel");
			address.setStudents(list_student);
			
			session.save(s1);
			session.save(s2);
			
			session.save(address);


			
			tx.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	}
}
