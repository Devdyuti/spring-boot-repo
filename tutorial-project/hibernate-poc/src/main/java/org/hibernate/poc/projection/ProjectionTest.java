package org.hibernate.poc.projection;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.tutorial.hibernate.poc.autoddl.Employee;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;
/*In Hibernate Projections are used to Select column like SELECT NAME, EMAIL from table
 * Criteria used to get all records from table based on some condition like SELECT * from table WHERE name LIKE '%raju%'
 * */
public class ProjectionTest {
	public static void main(String[] args) {

		Transaction tx=null;
		Session session=null;
		SessionFactory sf=null;
		
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			// 1. Getting Single column record
//			Criteria cri=session.createCriteria(Employee.class);
//			Projection p1=Projections.property("name");
//			cri.setProjection(p1);
//			
//			List<String> emp=cri.list();
//			
//			for (String string : emp) {
//				System.out.println("Name: "+string);
//			}
			
			// 2. Getting multiple column record
			Criteria cri=session.createCriteria(Employee.class);
			Projection p1=Projections.property("name");
			Projection p2=Projections.property("email");
			
			ProjectionList pList=Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			
			cri.setProjection(pList);
			
			List<Object[]> list=cri.list();
			
			for (Object[] objects : list) {
				System.out.println(objects[0]+": "+objects[1]);
			}
			
			tx.commit();
			
		}catch (Exception e) {
			System.out.println("Exception in ProjectionTest:: "+e);
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	
	}
}
