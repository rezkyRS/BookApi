package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.dto.requestDto.AuthorRequestDto;
import com.example.book.dto.responseDto.AuthorResponseDto;
import com.example.book.model.Author;

@Service
public interface AuthorService {
	public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
	public List<AuthorResponseDto> getAuthors();
	public AuthorResponseDto getAuthorById(Long authorId);
	public Author getAuthor(Long authorId);
	public AuthorResponseDto deleteAuthor(Long authorId);
	public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto);
	public AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId);
	public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId);

}
