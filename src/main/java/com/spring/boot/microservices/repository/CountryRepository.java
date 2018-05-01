package com.spring.boot.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.microservices.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>, PagingAndSortingRepository<Country, Long>{

}
