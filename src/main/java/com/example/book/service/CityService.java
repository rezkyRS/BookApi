package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.dto.requestDto.CityRequestDto;
import com.example.book.model.City;

@Service
public interface CityService {
	public City addCity(CityRequestDto cityRequestDto);
	public List<City> getCities();
	public City getCity(Long cityId);
	public City deleteCity(Long cityId);
	public City editCity(Long cityId, CityRequestDto cityRequestDto);
}
