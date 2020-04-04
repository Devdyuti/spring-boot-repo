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
			
			Address add2=new Address(2, "Main campus hostel");
			
			PGStudent s1=new PGStudent(3, "Amit", add2);
			PGStudent s2=new PGStudent(4, "Pawan", add2);
		
			List<PGStudent> list_students=new ArrayList<PGStudent>();
			list_students.add(s1);
			list_students.add(s2);
			
			
			add2.setStudents(list_students);
			
			session.save(add2);
			session.save(s1);
			session.save(s2);


			
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
