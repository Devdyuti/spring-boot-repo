package org.hibernate.poc.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.tutorial.hibernate.poc.autoddl.Employee;
import org.tutorial.hibernate.poc.connection.CHibernateUtils;

public class CriteriaTest {
	public static void main(String[] args) {
		Transaction tx=null;
		Session session=null;
		SessionFactory sf=null;
		
		try {
			sf=CHibernateUtils.getSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			// 1. get all rows of table
//			Criteria cri=session.createCriteria(Employee.class);
//			List<Employee> results=cri.list();
//			
//			for (Employee employee : results) {
//				System.out.println(employee.getId());
//			}
			
			// 2. select single row based on some condition {select query with where clause}
			Criteria cri=session.createCriteria(Employee.class);
			Criterion criterion=Restrictions.ilike("name", "%Rakesh%");
			cri.add(criterion);
			Employee emp=(Employee)cri.uniqueResult();
			System.out.println("name: "+emp.getName());
			
			
			
		}catch (Exception e) {
			System.out.println("Exception in CriteriaTest:: "+e);
			tx.rollback();
		}finally {
			session.close();
			sf.close();
		}
	}
}
