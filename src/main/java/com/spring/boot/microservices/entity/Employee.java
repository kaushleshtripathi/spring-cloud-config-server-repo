package com.spring.boot.microservices.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPNO")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="job")
	private String job;
	@Column(name="mgr")
	private Integer mgr;
	@Column(name="hiredate")
	private Date hiredate;
	@Column(name="salary")
	private Integer salary;
	@Column(name="comm")
	private Integer comm;
	@Column(name="deptno")
	private Integer deptno;
	@Column(name="age")
	private Integer age;
	
	public Employee() {}
	
	public Employee(Integer id, String name, String job, Integer mgr, Date hiredate, Integer salary, Integer comm,
			Integer deptno, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.salary = salary;
		this.comm = comm;
		this.deptno = deptno;
		this.age = age;
	}

	/*@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="DEPARTMENT_EMPLOYEE", 
				joinColumns={@JoinColumn(name="EMPNO")}, 
				inverseJoinColumns={@JoinColumn(name="DEPTNO")})
	private Set<Department> department = new HashSet<Department>();*/
	
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	/*public Set<Department> getDepartment() {
		return department;
	}

	public void setDepartment(Set<Department> department) {
		this.department = department;
	}*/

	public Date getHiredate() {
		return hiredate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", mgr=" + mgr + ", hire_date=" + hiredate
				+ ", salary=" + salary + ", comm=" + comm + ", deptno=" + deptno + ", age=" + age + "]";
	}
	
	
}
