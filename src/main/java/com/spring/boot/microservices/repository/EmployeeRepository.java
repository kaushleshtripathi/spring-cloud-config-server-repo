package com.spring.boot.microservices.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.boot.microservices.entity.Employee1;

/**
 * @author Kaushlesh
 * Repository for Employee entity
 * 
 * 
 */

@Repository
public interface EmployeeRepository extends CrudRepository<Employee1, Integer> {
	
	@Modifying
	@Query("update Employee e set e.name=:name where e.id =:id")
	public void empPatch(@Param("name") String name, @Param("id")int id);
	
	@Modifying
	@Query("update Employee e set e.name=:name where e.id =:id")
	public void empPut(@Param("name") String name, @Param("id")int id);
	
	@Modifying
	@Query("delete from Employee e where e.name=:name and e.id =:id")
	public void delete(@Param("name") String name, @Param("id") int id);

    //@Query("select * from Employee1 s where s.age <= :age", native=true)
    //public List<Student> findByAgeLessThanEqual (long age);

}
