package org.tutorial.hibernate.poc.association;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;
import org.tutorial.hibernate.poc.orm.inheritance.table_per_concreteClass.Apple;
import org.tutorial.hibernate.poc.orm.inheritance.table_per_concreteClass.Fruit;
import org.tutorial.hibernate.poc.orm.inheritance.table_per_concreteClass.Orange;

public class OneToOne {
		public static void main(String[] args) {


			Transaction tx=null;
			SessionFactory sf=null;
			Session session=null;
			try {
				sf=CHibernateUtils.getSessionFactory();
				session=sf.openSession();
				tx=session.beginTransaction();
				
				Voter v=new Voter(1, "Sudhir", 30);
				Vote vt=new Vote("BJP", new Date());
				vt.setVoter(v);
				
				
				session.save(v);
				session.save(vt);
				
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
