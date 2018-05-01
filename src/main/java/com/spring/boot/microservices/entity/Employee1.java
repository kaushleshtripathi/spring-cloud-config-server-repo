package com.spring.boot.microservices.entity;

/**
 * @author Kaushlesh
 *
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE1")
public class Employee1 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
    private Integer id;
	@Column(name = "NAME")
    private String name;
	@Column(name = "SALARY")
    private long salary;
	@Column(name = "AGE")
    private Integer age;
    
    /*@DateTimeFormat(pattern="dd/MM/yyyy")
    private Date hireDate;*/
    
    public Employee1() {}
    
    public Employee1(Integer id, String name, long salary, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}


