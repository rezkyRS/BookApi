package com.example.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.book.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
