package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ProductService;
import com.example.service.UserService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired

	
	@GetMapping(value = "/products/new")
	public String newProduct() {
		return "newProduct";
	}


}
