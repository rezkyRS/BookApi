package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.dto.requestDto.CategoryrequestDto;
import com.example.book.dto.responseDto.CategoryResponseDto;
import com.example.book.model.Category;

@Service
public interface CategoryService {
	public Category getCategory(Long categoryId);
	public CategoryResponseDto addCategory(CategoryrequestDto categoryrequestDto);
	public CategoryResponseDto getCategoryById(Long categoryId);
	public List<CategoryResponseDto> getCategories();
	public CategoryResponseDto deleteCategory(Long categoryId);
	public CategoryResponseDto editCategory(Long categoryId, CategoryrequestDto categoryrequestDto);
}
