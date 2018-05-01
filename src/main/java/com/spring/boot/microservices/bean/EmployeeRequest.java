package com.spring.boot.microservices.bean;

public class EmployeeRequest {

	private EmployeeDTO[] employee;

	public EmployeeDTO[] getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO[] employee) {
		this.employee = employee;
	}

}
