package org.tutorial.hibernate.poc.association;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class OneToMany {
	public static void main(String[] args) {
		Transaction tx=null;
		SessionFactory sf=null;
		Session session=null;
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			Teacher teacher=new Teacher(2, "XXNaveen");
			
			
			Topic t1=new Topic(1, "XXSpring core", 60, teacher);
			Topic t2=new Topic(2, "XXSpring mvc", 30, teacher);
			Topic t3=new Topic(3, "XXSpring aop", 40, teacher);

			
			List<Topic> list=new ArrayList<Topic>();
			list.add(t1);
			list.add(t2);
			list.add(t3);
			
			teacher.setTopics(list);
			
			session.save(teacher);  // if using CASCADE then no need to save Parent. when child save, Parent will save automatically.
			session.save(t1);
			session.save(t2);
			session.save(t3);
			
			
			tx.commit();
			
		}catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
			tx.rollback();
			System.out.println("Data Rollbacked");
		}finally {
			session.close();
			sf.close();
		}
	}
}
