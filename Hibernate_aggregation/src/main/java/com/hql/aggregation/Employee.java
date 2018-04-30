package com.hql.aggregation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({@NamedQuery(name = "@GET_ALL_EMPLOYEES", query = "FROM Employee e"),
	@NamedQuery(name = "@GET_ALL_NAME", query = "select e.name,e.age FROM Employee e where e.id = :id ")
})
@Entity
@Table(name = "Employee ")
public class Employee {
	@Id
	private Integer id;
	private Integer age;
	private String name;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"age\":\"" + age + "\", \"name\":\"" + name + "\"}";
	}
	
	
}
