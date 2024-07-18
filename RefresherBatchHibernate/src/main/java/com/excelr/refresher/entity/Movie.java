package com.excelr.refresher.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mno;
	private String mname;
	private int releaseYear;
	
	@ManyToMany(mappedBy = "portfolio")
	List<Actor> starcast;
	
}
