package com.spring.boot.microservices.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.microservices.WebServiceError;
import com.spring.boot.microservices.bean.EmployeeDTO;
import com.spring.boot.microservices.entity.Country;
import com.spring.boot.microservices.entity.Employee1;
import com.spring.boot.microservices.service.EmployeeService;

//http://websystique.com/spring-boot/spring-boot-rest-api-example/

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmployeeRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired 
	Environment env;
	
	EmployeeService employeeService;
	
	@Autowired	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@Value("${msg.resource.created.success}")
	private String postCreatedSuccess;
	
	@RequestMapping("/test")
	public String getHello() {
		return employeeService.sayHello();
	}
	
	@RequestMapping("/test/{name}")
	public String getName(@PathVariable String name) {
		 logger.info("bootrest.customproperty "+ env.getProperty("bootrest.customproperty"));
		return "Hello :"+name;
	}
	
		
	@GetMapping("/employees")
	public ResponseEntity<List<Employee1>> getEmployees() {
		List<Employee1> list = employeeService.getEmployees();
		return new ResponseEntity<List<Employee1>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getCountries() {
		List<Country> list = employeeService.getCountries();
		return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee1> getAllEmployees() {
		List<Employee1> list = employeeService.getEmployees();
		System.out.println("list :"+list);
		return list;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
	     
		employeeService.save(employeeDTO);
	    return ResponseEntity.ok(postCreatedSuccess);
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveResource(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable("id") int id, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("");
		}
				
		employeeService.put(employeeDTO, id);
		
	    return ResponseEntity.ok("resource updated successfully");
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> partialUpdateGeneric(@RequestBody Map<String, Object> fields, @PathVariable("id") int id) {
	     
		employeeService.patch(fields, id);
	    
	    return ResponseEntity.ok("resource patched successfully");
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@RequestBody EmployeeDTO employee, @PathVariable("id") int id) {
	    
		Employee1 emp = new Employee1();
		BeanUtils.copyProperties(employee, emp);
		
		employeeService.delete(emp, id);
	    
	    return ResponseEntity.ok("resource deleted successfully");
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e) {
	    List<ObjectError> errors = e.getBindingResult().getAllErrors();
	 
	    WebServiceError webServiceError = WebServiceError.build(WebServiceError.Type.VALIDATION_ERROR, errors.get(0).getObjectName() + " " + errors.get(0).getDefaultMessage());
	 
	    return new ResponseEntity<>(webServiceError, HttpStatus.BAD_REQUEST);
	}
}
