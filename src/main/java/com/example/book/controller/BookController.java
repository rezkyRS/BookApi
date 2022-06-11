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

import com.example.book.dto.requestDto.BookRequestDto;
import com.example.book.dto.responseDto.BookResponseDto;
import com.example.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto){
		BookResponseDto book = bookService.addBook(bookRequestDto);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<BookResponseDto> getBook(@PathVariable final Long id){
		BookResponseDto book = bookService.getBookById(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<BookResponseDto>> getBooks(){
		List<BookResponseDto> book = bookService.getBooks();
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BookResponseDto> deleteBook(@PathVariable final Long id){
		BookResponseDto book = bookService.deleteBook(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<BookResponseDto> addBook(@PathVariable final Long id,
			@RequestBody BookRequestDto bookRequestDto){
		BookResponseDto book = bookService.editBook(id, bookRequestDto);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/addcategory/{categoryId}/tobook/{bookId}")
	public ResponseEntity<BookResponseDto> addCategoryToBook(@PathVariable final Long categoryId,
			@PathVariable final Long bookId){
		BookResponseDto book = bookService.addCategoryToBook(bookId, categoryId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/removecategory/{categoryId}/from/{bookId}")
	public ResponseEntity<BookResponseDto> removeCategoryFromBook(@PathVariable final Long cayegoryId,
			@PathVariable final Long bookId){
		BookResponseDto book = bookService.deleteCategoryFromBook(bookId, cayegoryId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/addauthor/{authorId}/to/{bookId}")
	public ResponseEntity<BookResponseDto> addAuthorToBook(@PathVariable final Long authorId,
			@PathVariable final Long bookId){
		BookResponseDto book = bookService.addAuthorToBook(bookId, authorId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping("/removeauthor/{authorId}/from/{bookId}")
	public ResponseEntity<BookResponseDto> removeAuthorFromBook(@PathVariable final Long authorId,
			@PathVariable final Long bookId){
		BookResponseDto book = bookService.deleteAuthorFromBook(bookId, authorId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	
	

}
