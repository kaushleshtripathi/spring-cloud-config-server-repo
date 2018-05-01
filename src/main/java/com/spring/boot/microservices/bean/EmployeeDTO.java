package com.spring.boot.microservices.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class EmployeeDTO {

	@Min(1)
	@Max(6)
	private Integer id;
	@NotNull(message = "Employee name can't be null")
	private String name;
	private long salary;
	private Integer age;

	// @DateTimeFormat(pattern="dd/MM/yyyy")
	// private Date hireDate;

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
