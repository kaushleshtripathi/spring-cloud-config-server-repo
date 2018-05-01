package com.spring.boot.microservices.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spring.boot.microservices.bean.EmployeeDTO;
import com.spring.boot.microservices.entity.Country;
import com.spring.boot.microservices.entity.Employee1;

@Component
public interface EmployeeService {
	
	//POST
	public Employee1 save(EmployeeDTO employeeDTO);
	
	//PUT
	public void put(EmployeeDTO employeeDTO, int id);
	
	//PATCH
	public void patch(Map<String, Object> updates, int id);
	
	//DELETE
	public void delete(Employee1 employee, int id);
	
	public String sayHello();
	
	public List<Employee1> getEmployees();
	
	public List<Country> getCountries();
}
