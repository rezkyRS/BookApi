package com.example.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.book.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

}
