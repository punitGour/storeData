package com.store.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Users {
	
	@Id
	String username;
	String email;
	String city;
	String age;
	String password;
	
	
	
	
	public Users(String username, String email, String city, String age, String password) {
		super();
		this.username = username;
		this.email = email;
		this.city = city;
		this.age = age;
		this.password = password;
	}
	
	public Users() {
		
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", email=" + email + ", city=" + city + ", age=" + age + ", password="
				+ password + "]";
	}
	
	
	

}
