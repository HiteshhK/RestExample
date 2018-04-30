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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.tutorialspoint.Employee;
import com.tutorialspoint.EmployeeDAO;
 
 
@Path("/employees")
public class MyResource {
 
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List employees = dao.getEmployees();
        System.out.println(employees);
        return "{\"result\":" +employees+"}";
//        return Response.ok().entity(employees).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
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
    public String addEmployee(@QueryParam("name") String name,@QueryParam("id") Integer id,@QueryParam("age") Integer age){
        try {
        	Employee emp = new Employee();
        	emp.setId(id);
			emp.setName(name);
			emp.setAge(age);
			System.out.println("called");
			        
			EmployeeDAO dao = new EmployeeDAO();
			boolean flag = (dao.addEmployee(emp));
			if(flag == false) {
				System.out.println("not added");
				return "{result:could not add the entity}";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        return "{result:added successfully}";
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
    	emp.setId(3);
    	emp.setAge(24);
    	emp.setName("amit");
    	EmployeeDAO dao = new EmployeeDAO();
    	dao.addEmployee(emp);
    	
	}
}