package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "long_id")
	private Long id;
	
	@PositiveOrZero(message = " wholesale price cannot be negative")
	private int quantity;
	
	@PositiveOrZero(message = "Product retail price cannot be negative")
	private Double price;
	
	@NotBlank(message = "Product brand cannot be blank")
	private String brand;
	
	@NotBlank(message = "Product category cannot be blank")
	private String category;
	
	private String description;
	
	private String name; // range between 0 to positive
	
	private String image;
	
	 //image attribute is a string representing the path where the image file is stored
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	public Product() {
	}

	public Product(@PositiveOrZero(message = " wholesale price cannot be negative") int quantity,
			@PositiveOrZero(message = "Product retail price cannot be negative") Double price,
			@NotBlank(message = "Product brand cannot be blank") String brand,
			@NotBlank(message = "Product category cannot be blank") String category, String description, String name,
			String image, Date createdAt, Date updatedAt) {
		this.quantity = quantity;
		this.price = price;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.name = name;
		this.image = image;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", quantity=" + quantity + ", price=" + price + ", brand=" + brand + ", category="
				+ category + ", description=" + description + ", name=" + name + ", image=" + image + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
