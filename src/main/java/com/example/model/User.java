package com.example.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Please provide an email")
	private String userName;
	
	@NotEmpty(message = "Please provide an email")
	private String passWord;
	
	@ElementCollection
	private List<HashMap<Product, Integer>> cart;
	
	private Integer active;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(@NotEmpty(message = "Please provide an email") String userName,
			@NotEmpty(message = "Please provide an email") String passWord, List<HashMap<Product, Integer>> cart,
			Integer active) {
		this.userName = userName;
		this.passWord = passWord;
		this.cart = cart;
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<HashMap<Product, Integer>> getCart() {
		return cart;
	}

	public void setCart(List<HashMap<Product, Integer>> cart) {
		this.cart = cart;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", cart=" + cart + ", active="
				+ active + "]";
	}
	
	

}