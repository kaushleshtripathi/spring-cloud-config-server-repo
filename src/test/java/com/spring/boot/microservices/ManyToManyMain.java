package com.spring.boot.microservices;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.boot.microservices.entity.Department;
import com.spring.boot.microservices.entity.Employee;

public class ManyToManyMain {
	
	@Autowired 
	private static EntityManager entityManager;
	
	@Autowired
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Department dept1 = new Department(100,"IT", "Pune");
        Department dept2 = new Department(101,"SALES", "MUMBAI");
        
        Employee emp1 = new Employee(1,"Brin","Sergey", null, null, null,null,null, null);
        Employee emp2 = new Employee(2, "Page","Larry", null, null, null,null,null, null);

      /*  emp1.getDepartment().add(dept1);
        emp2.getDepartment().add(dept2);*/
        
        session.save(emp1);
        session.save(emp2);
        
        session.getTransaction().commit();
        session.close();
	}

}
