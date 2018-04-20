package com.tutorialspoint;
 
import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.tutorialspoint.Employee;
import com.tutorialspoint.EmployeeDAO;
 
 
@Path("/employees")
public class MyResource {
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List employees = dao.getEmployees();
        System.out.println(employees);
        return "{\"result\":" +employees+"}";
    }
 
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
    	return "{\"name\":hitesh,\"age\":21}";
    }
    	
    
    @GET
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee emp){
        try {
        	emp = new Employee();
        	emp.setId(2);
			emp.setName("suresh");
			emp.setAge(23);
			System.out.println("called");
			        
			EmployeeDAO dao = new EmployeeDAO();
			dao.addEmployee(emp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id, Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployee(id, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("id") int id){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployee(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    public static void main(String[] args) {
    	System.out.println("inside main");
    	Employee emp = new Employee();
    	emp.setId(1);
    	emp.setAge(21);
    	emp.setName("hitesh");
    	EmployeeDAO dao = new EmployeeDAO();
    	dao.addEmployee(emp);
    	
	}
}