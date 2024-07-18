package com.excelr.refresher.entity;



import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="StudentTable")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rollno")
	private int rno;
	@Column(name="studentname", length = 20)
	private String sname;
	
	@Column(unique = true)
	private String email;
	
	@Column(name="percentage")
	private double per;

	
}
