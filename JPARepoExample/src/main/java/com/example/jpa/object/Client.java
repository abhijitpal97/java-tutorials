package com.example.jpa.object;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CLIENT")
public class Client {
	
	@Id
	@SequenceGenerator(name="clientseq",sequenceName="CLIENTSEQUENCE", allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "clientseq")
	@Column(name = "CLIENTID")
	private int clientId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LOCATION")
	private String location;
	
	
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "client")
	@JsonManagedReference
	private Order order;


	public int getClientId() {
		return clientId;
	}


	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


}
