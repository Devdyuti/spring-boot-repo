package org.tutorial.hibernate.poc.orm.inheritance.table_per_concreteClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;
import org.tutorial.hibernate.poc.orm.inheritance.table_per_subclass.Cat;
import org.tutorial.hibernate.poc.orm.inheritance.table_per_subclass.Dog;

public class TablePerConcreteClass {
	public static void main(String[] args) {

		Transaction tx=null;
		SessionFactory sf=null;
		Session session=null;
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			Fruit f=new Fruit(1, "Apple-Fruit", "kashmir");
			Apple a=new Apple(2, "Apple", "kashmir", "greenAppi");
			Orange o=new Orange(3, "Orange", "nagpur", "yellow");
			
			session.save(f);
			session.save(a);
			session.save(o);
			
			tx.commit();
			
			session.evict(f);
			session.evict(a);
			session.evict(o);
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	
	}
}
