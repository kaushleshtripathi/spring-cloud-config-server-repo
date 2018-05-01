package com.spring.boot.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "count_Id")
	private Long countId;
	
	@Column(name = "name")
	private String name;
	
	public State() {}
	public State(Long countId, Country country) {
		this.countId=countId;
		this.country=country;
	}
	
	@ManyToOne
	@JoinColumn(name = "count_Id",referencedColumnName="id", insertable=false, updatable=false)
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCountId() {
		return countId;
	}

	public void setCountId(Long countId) {
		this.countId = countId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
