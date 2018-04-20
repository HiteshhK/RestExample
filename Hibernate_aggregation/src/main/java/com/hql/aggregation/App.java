package com.hql.aggregation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.StandardEmitterMBean;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;



 
public class App 
{
	private static SessionFactory factory;
    public static void main( String[] args )
    {
       factory = SessionConnect.getSessionFactory();
       Session session = factory.openSession();
       Transaction t = session.beginTransaction();
       
        
       /*Query query = session.getNamedQuery("@GET_EMP_BY_FIRST_NAME").setParameter("FIRST_NAME", "Shelley");
       List<Employees> emp = query.getResultList();
       System.out.println(emp);*/
       
       Query query1 = session.getNamedQuery("@GET_EMP_BY_LAST_NAME").setParameter("LAST_NAME", "Higgins");
       List<Object> emp1 = query1.getResultList();
       Iterator itr = emp1.iterator();
       while(itr.hasNext()) {
    	   Object obj[] = (Object[])itr.next();
    	   System.out.println(obj[0] + " "+ obj[1]);
       }
       
       NativeQuery nativeQuery = session.getNamedNativeQuery("@GET_NAME_SALARY_DEPARTMENT");
       nativeQuery.getQueryString();
       nativeQuery.addScalar("EMAIL",  StandardBasicTypes.STRING);
       nativeQuery.addScalar("SALARY",  StandardBasicTypes.INTEGER);
       List<Object> obj = nativeQuery.getResultList();
       Iterator itr1 = obj.iterator();
       while(itr1.hasNext()) {
    	   Object obj1[] = (Object[])itr1.next();
    	   System.out.println(obj1[0] + " "+ obj1[1]);
       }
       
       //       Iterator<Employees> itr = emp.iterator();
//       while(itr.hasNext()) {
//    	   Employees e = itr.next();
//    	   System.out.println(e);
//       }
       /**
        * For HQL
        */
       /*Query query = session.createQuery("FROM Employees E WHERE E.SALARY > 11000 ORDER BY E.FIRST_NAME DESC, E.SALARY DESC");
       List<Employees> employees = query.getResultList();
       System.out.println(employees);*/
       
       /**
        * for Native Query
        */
      /* NativeQuery nq = session.createNativeQuery("select *  from Employees");
       nq.addEntity(Employees.class);
      List<Employees> emp = nq.list();
       session.close();
       System.out.println(emp);*/
/*		List employees = new ArrayList();
		employees = session.createQuery("From Employees").list();
		System.out.println("|S.NO|FName|LName|EMP_ID PrimaryKey|");
		Employees e1 = new Employees();
		for(int i = 0 ; i < employees.size(); i ++)
		{
			e1 =(Employees) employees.get(i);
			System.out.println("------------------------");
			System.out.println("| "+ (i+1) + " | "+e1.getFIRST_NAME() + " | " + e1.getLAST_NAME()+" | "+e1.getEMPLOYEE_ID());
		}*/
       
    }
}
