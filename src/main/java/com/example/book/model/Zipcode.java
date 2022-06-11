package com.example.book.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Zipcode")
public class Zipcode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private City city;
	public Zipcode(String name, City city) {
		this.name = name;
		this.city = city;
	}
	

}
