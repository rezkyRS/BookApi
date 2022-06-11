package com.example.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.book.model.Zipcode;

@Repository
public interface ZipcodeRepository extends CrudRepository<Zipcode, Long>{

}
