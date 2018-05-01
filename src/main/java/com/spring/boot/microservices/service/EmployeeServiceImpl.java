package com.spring.boot.microservices.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.microservices.bean.EmployeeDTO;
import com.spring.boot.microservices.repository.CountryRepository;
import com.spring.boot.microservices.repository.EmployeeRepository;
import com.spring.boot.microservices.entity.Country;
import com.spring.boot.microservices.entity.Employee1;
//import com.spring.boot.microservices.test.dao.EmployeeDao;

//http://www.namooz.com/2016/12/10/spring-boot-restful-web-service-example-get-post-put-delete-patch/

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public String sayHello() {
		return "Hello, Welcome to Spring Boot ....";
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Employee1> getEmployees() {
		return (List<Employee1>) employeeRepository.findAll();
	}
	
	//POST
	@Transactional
	public Employee1 save(EmployeeDTO employeeDTO){
		
		Employee1 employee = new Employee1();
		BeanUtils.copyProperties(employeeDTO, employee);
		
		return employeeRepository.save(employee);
	}
		
	//PUT
	@Transactional
	public void put(EmployeeDTO employeeDTO, int id){
		
		Employee1 employee = new Employee1();
		BeanUtils.copyProperties(employeeDTO, employee);
		
		employeeRepository.empPut(employee.getName(), id);
	}
		
	//PATCH
	@Transactional
	public void patch(Map<String, Object> updates, int id){
		employeeRepository.empPatch(updates.get("name").toString(), id);
	}
	
	//PATCH
	@Transactional
	public void delete(Employee1 employee, int id){
		employeeRepository.delete(employee.getName(), id);
	}
	
	@Transactional
	public List<Country> getCountries(){
		return (List<Country>) countryRepository.findAll();
	}
	
	

}
