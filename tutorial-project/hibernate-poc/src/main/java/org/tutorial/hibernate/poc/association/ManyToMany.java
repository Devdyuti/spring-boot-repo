package org.tutorial.hibernate.poc.association;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class ManyToMany {
	public static void main(String[] args) {
		Transaction tx=null;
		SessionFactory sf=null;
		Session session=null;
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			Course c1=new Course(1, "core java", 700);
			Course c2=new Course(2, "java8", 400);
			Course c3=new Course(3, "aws", 430);
			Course c4=new Course(4, "mockito", 745);
			
			Set<Course> cset1=new HashSet<Course>();
			Set<Course> cset2=new HashSet<Course>();
			cset1.add(c1);
			cset1.add(c2);
			
			cset2.add(c3);
			cset2.add(c4);
			
			Faculty f1=new Faculty(1, "Durga", 20);
			Faculty f2=new Faculty(2, "Naveen", 10);
			Faculty f3=new Faculty(3, "Devdyuti", 5);
			
			f1.setCourses(cset1);
			f2.setCourses(cset2);
			f3.setCourses(cset2);

			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);
			
			session.save(f1);
			session.save(f2);
			session.save(f3);

			tx.commit();
			
		}catch (Exception e) {
			System.out.println("Exception in M2M** "+e);
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	}
}
