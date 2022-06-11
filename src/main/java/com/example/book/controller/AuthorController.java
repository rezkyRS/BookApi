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

import com.example.book.dto.requestDto.AuthorRequestDto;
import com.example.book.dto.responseDto.AuthorResponseDto;
import com.example.book.model.Author;
import com.example.book.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@PostMapping("/addauthor")
	public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
		AuthorResponseDto author = authorService.addAuthor(authorRequestDto);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	@GetMapping("/getauthor/{id}")
	public ResponseEntity<AuthorResponseDto> findAuthorById(@PathVariable final Long id){
		AuthorResponseDto author = authorService.getAuthorById(id);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<AuthorResponseDto>> getAuthors(){
		List<AuthorResponseDto> authors = authorService.getAuthors();
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable final Long id){
		AuthorResponseDto author = authorService.deleteAuthor(id);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable final Long id,
			@RequestBody AuthorRequestDto authorRequestDto){
		AuthorResponseDto author = authorService.editAuthor(id, authorRequestDto);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	@PostMapping("/addzipcode/{zipcodeId}/to/{authorId}")
	public ResponseEntity<AuthorResponseDto> addZipcodeToAuthor(@PathVariable final Long zipcodeId,
			@PathVariable final Long authorId){
		AuthorResponseDto author = authorService.addZipcodeToAuthor(authorId, zipcodeId);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	@PostMapping("/removezipcode/{id}")
	public ResponseEntity<AuthorResponseDto> removeZipcodeFromAuthor(@PathVariable final Long id){
		AuthorResponseDto author = authorService.deleteZipcodeFromAuthor(id);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	
}
