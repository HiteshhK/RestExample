package com.tutorialspoint;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO {
	private static SessionFactory factory;
	public void addEmployee(Employee bean){
		System.out.println("inside create method");
		
		factory = SessionConnect.getSessionFatoryObject();
        Session session = factory.openSession();
        System.out.println("created session");
        Transaction tx = session.beginTransaction();
        addEmployee(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addEmployee(Session session, Employee bean){
//        Employee employee = new Employee();
        System.out.println("inside addEmployee method"+bean.getName());
        /*employee.setName(bean.getName());
        employee.setAge(bean.getAge());
        employee*/
        System.out.println(bean);
        session.save(bean);
        System.out.println("saved successfully");
    }
    
    public List<Employee> getEmployees(){
    	factory = SessionConnect.getSessionFatoryObject();
        Session session = factory.openSession();     
        Query query = session.createQuery("from Employee");
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
