package com.example.addConfig;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {

	@Id
	@SequenceGenerator(name = "studentseq" , sequenceName = "STUDENTSEQUENCE" , allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "studentseq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "student")
	private List<Subject> learningSubjects;
	
	public Student (CreateStudentRequest createStudentRequest) {
		this.firstName = createStudentRequest.getFirstName();
		this.lastName = createStudentRequest.getLastName();
		this.email = createStudentRequest.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Subject> getLearningSubjects() {
		return learningSubjects;
	}

	public void setLearningSubjects(List<Subject> learningSubjects) {
		this.learningSubjects = learningSubjects;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
}
