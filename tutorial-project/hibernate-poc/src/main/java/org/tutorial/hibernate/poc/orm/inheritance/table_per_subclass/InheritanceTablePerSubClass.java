package org.tutorial.hibernate.poc.orm.inheritance.table_per_subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class InheritanceTablePerSubClass {
	public static void main(String[] args) {
		Transaction tx=null;
		SessionFactory sf=null;
		Session session=null;
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			Dog d=new Dog(1, "Monu", 5, "bhubhu");
			Cat c=new Cat(2, "Miya", 2, "miyau");
			
			session.save(d);
			session.save(c);
			
			tx.commit();
			
			session.evict(d);
			session.evict(c);
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	}
}
