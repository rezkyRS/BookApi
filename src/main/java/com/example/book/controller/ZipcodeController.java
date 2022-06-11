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

import com.example.book.dto.requestDto.ZipcodeRequestDto;
import com.example.book.model.Zipcode;
import com.example.book.service.ZipcodeService;

@RestController
@RequestMapping("/zipcode")
public class ZipcodeController {
	
	private final ZipcodeService zipcodeService;

	@Autowired
	public ZipcodeController(ZipcodeService zipcodeService) {
		this.zipcodeService = zipcodeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Zipcode> addZipcode(@RequestBody ZipcodeRequestDto zipcodeRequestDto){
		Zipcode zipcode = zipcodeService.addZipcode(zipcodeRequestDto);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Zipcode> getZipcode(@PathVariable final Long id){
		Zipcode zipcode = zipcodeService.getZipcode(id);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Zipcode>> getZipcodes(){
		List<Zipcode> zipcodes = zipcodeService.getZipcodes();
		return new ResponseEntity<>(zipcodes, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Zipcode> deleteZipcode(@PathVariable final Long id){
		Zipcode zipcode = zipcodeService.deleteZipcode(id);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<Zipcode> editZipcode(@PathVariable final Long id,
			@RequestBody ZipcodeRequestDto zipcodeRequestDto){
		Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@PostMapping("/addcity/{cityId}/tozipcode/{zipcodeId}")
	public ResponseEntity<Zipcode> addCityToZipcode(@PathVariable final Long cityId,
			@PathVariable final long zipcodeId){
		Zipcode zipcode = zipcodeService.addCityToZipcode(zipcodeId,cityId);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@PostMapping("/deletecity/{id}")
	public ResponseEntity<Zipcode> deleteCityFromZipcode(@PathVariable final Long id){
		Zipcode zipcode = zipcodeService.removeCityFromZipcode(id);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
}
