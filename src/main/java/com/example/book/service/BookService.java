package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.dto.requestDto.BookRequestDto;
import com.example.book.dto.responseDto.BookResponseDto;
import com.example.book.model.Book;

@Service
public interface BookService {
	public BookResponseDto addBook(BookRequestDto bookRequestDto);
	public BookResponseDto getBookById(Long bookId);
	public Book getBook(Long bookId);
	public List<BookResponseDto> getBooks();
	public BookResponseDto deleteBook(Long bookId);
	public BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto);
	public BookResponseDto addAuthorToBook(Long bookId, Long authorId);
	public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId);
	public BookResponseDto addCategoryToBook(Long bookId, Long categoryId);
	public BookResponseDto deleteCategoryFromBook(Long bookId, Long categoryId);
	
}
