package com.example.addConfig;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@SequenceGenerator(name = "addressseq" , sequenceName = "ADDRESSSEQUENCE" , allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "addressseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;
	
	@OneToOne(mappedBy = "address")
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
