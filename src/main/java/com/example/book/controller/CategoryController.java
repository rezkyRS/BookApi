package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.dto.requestDto.CategoryrequestDto;
import com.example.book.dto.responseDto.CategoryResponseDto;
import com.example.book.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryrequestDto categoryrequestDto){
		CategoryResponseDto categoryResponseDto = categoryService.addCategory(categoryrequestDto);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable final Long id){
		CategoryResponseDto categoryResponseDto = categoryService.getCategoryById(id);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<CategoryResponseDto>> getCategories(){
		List<CategoryResponseDto> categoryResponseDtos = categoryService.getCategories();
		return new ResponseEntity<>(categoryResponseDtos, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable final Long id){
		CategoryResponseDto categoryResponseDto = categoryService.deleteCategory(id);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<CategoryResponseDto> editCategory(@RequestBody CategoryrequestDto categoryrequestDto,
			@PathVariable final Long id){
		CategoryResponseDto categoryResponseDto = categoryService.editCategory(id, categoryrequestDto);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	
	
	
	
}
