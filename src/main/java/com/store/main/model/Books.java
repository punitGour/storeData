package com.store.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Books {
	
	@Id
	String ID;
	String name;
	String price;
	String author;
	String publishedYear;
	String discount;
	String status;
	
	
	
	public Books(String ID, String name, String price, String author, String publishedYear, String discount, String status) {
		super();
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publishedYear = publishedYear;
		this.discount = discount;
		this.status = status;
	}
	public Books() {
		
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Books [ID=" + ID + ", name=" + name + ", price=" + price + ", author=" + author + ", publishedYear="
				+ publishedYear + ", discount=" + discount + ", status=" + status + "]";
	}
	
	

}
