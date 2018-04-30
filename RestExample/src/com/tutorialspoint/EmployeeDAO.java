package com.tutorialspoint;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO {
	private static SessionFactory factory;
    
    public boolean addEmployee(Employee bean){
    	System.out.println("inside create method");
		factory = SessionConnect.getSessionFatoryObject();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
			
//        Employee employee = new Employee();
			System.out.println("inside addEmployee method "+bean.getName());
			/*employee.setName(bean.getName());
			employee.setAge(bean.getAge());
			employee*/
			try {
				session.save(bean);
				session.flush();
				session.clear();
			
			tx.commit();
			
			System.out.println("saved successfully");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			 if (tx != null) tx.rollback();
			 System.out.println("error in saving");
			 return false;
			    
		}
			catch(Exception e) {
				System.out.println("main error");
				e.printStackTrace();
				return false;
			}
			finally {
			session.close();
		}
    }
    
    public List<Employee> getEmployees(){
    	factory = SessionConnect.getSessionFatoryObject();
        Session session = factory.openSession();     
//        Query query = session.createQuery("from Employee");
        Query query = session.getNamedQuery("@GET_ALL_EMPLOYEES");
        List<Employee> employees =  query.list();
        session.close();
        return employees;
    }
 
    public int deleteEmployee(int id) {
    	factory = SessionConnect.getSessionFatoryObject();
        Session session = factory.openSession();
        String hql = "delete from Employee where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateEmployee(int id, Employee emp){
         if(id <=0)  
               return 0;  
         factory = SessionConnect.getSessionFatoryObject();
         Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Employee set name = :name, age=:age where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id",id);
            query.setParameter("name",emp.getName());
            query.setParameter("age",emp.getAge());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
	
}
