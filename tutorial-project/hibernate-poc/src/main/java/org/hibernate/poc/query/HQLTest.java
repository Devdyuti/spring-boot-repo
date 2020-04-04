package org.hibernate.poc.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.association.Teacher;
import org.tutorial.hibernate.poc.association.Topic;
import org.tutorial.hibernate.poc.autoddl.Employee;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class HQLTest {
	public static void main(String[] args) {

		Transaction tx=null;
		Session session=null;
		SessionFactory sf=null;
		
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			//1. Query query=null;
//			Query query=session.createQuery("from employee");
//			List<Employee> emp=query.list();
//			
//			for (Employee employee : emp) {
//				System.out.println(employee.getName()+" "+employee.getEmail());
//			}
			
			// 2. Hql join query
			//String sql="select teacher.name, topic.tname, topic.tduration from teacher inner join topic on teacher.teacher_id=topic.teacher_id";
			Query query=session.createQuery("from topic t  INNER JOIN t.teacher e");
			List<Object[]> list=query.list();
			
			for (Object[] objects : list) {
				Topic topic=(Topic) objects[0];
				Teacher teacher=(Teacher) objects[1];
				
				System.out.println(topic.getTname()+" : "+teacher.getName());
			}
			
			
	
			tx.commit();
			
		}catch (Exception e) {
			System.out.println("Exception in QueryTest:: "+e);
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	
	}
}
