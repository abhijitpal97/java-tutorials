package com.example.jpa.object;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ORDERDETAILS")
public class Order {
	
	@Id
	@SequenceGenerator(name="orderseq",sequenceName="ORDERSEQUENCE", allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "orderseq")
	@Column(name = "ORDERID")
	private int orderId;
	@Column(name = "ITEM")
	private String item;
	@Column(name = "QUANTITY")
	private int quantitiy;
	@Column(name = "PRICE")
	private float price;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENTID")
	@JsonBackReference
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantitiy() {
		return quantitiy;
	}
	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	

}
