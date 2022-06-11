package com.example.book.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.dto.mapper;
import com.example.book.dto.requestDto.CategoryrequestDto;
import com.example.book.dto.responseDto.CategoryResponseDto;
import com.example.book.model.Category;
import com.example.book.repository.CategoryRepository;
import com.example.book.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category getCategory(Long categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(() ->
		new IllegalArgumentException("could not find category with id"+categoryId));
	}

	@Override
	public CategoryResponseDto addCategory(CategoryrequestDto categoryrequestDto) {
		Category category = new Category();
		category.setName(categoryrequestDto.getName());
		categoryRepository.save(category);
		return mapper.categoryToCategoryResponseDto(category);
	}

	@Override
	public CategoryResponseDto getCategoryById(Long categoryId) {
		Category category = getCategory(categoryId);
		return mapper.categoryToCategoryResponseDto(category);
	}

	@Override
	public List<CategoryResponseDto> getCategories() {
		List<Category> categories = StreamSupport
				.stream(categoryRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return mapper.categoriesToCategoryResponseDtos(categories);
	}

	@Override
	public CategoryResponseDto deleteCategory(Long categoryId) {
		Category category = getCategory(categoryId);
		categoryRepository.delete(category);
		return mapper.categoryToCategoryResponseDto(category);
	}

	@Transactional
	@Override
	public CategoryResponseDto editCategory(Long categoryId, CategoryrequestDto categoryrequestDto) {
		Category categoryToEdit = getCategory(categoryId);
		categoryToEdit.setName(categoryrequestDto.getName());
		return mapper.categoryToCategoryResponseDto(categoryToEdit);
	}

}
