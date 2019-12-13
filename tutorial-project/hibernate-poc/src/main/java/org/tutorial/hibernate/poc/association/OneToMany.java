package org.tutorial.hibernate.poc.association;

import java.util.ArrayList;
import java.util.Date;
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
			
			Teacher teacher=new Teacher(1, "Durga");
			
			Topic t1=new Topic(1, "java", 60, teacher);
			Topic t2=new Topic(2, "php", 30, teacher);
			
			List<Topic> list=new ArrayList<Topic>();
			list.add(t1);
			list.add(t2);
			
			teacher.setTopics(list);
			
			session.save(teacher);
			session.save(t1);
			session.save(t2);


			
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
