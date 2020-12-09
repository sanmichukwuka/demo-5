package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;
import com.example.service.ProductService;

import lombok.Data;

@Data
@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all controllers, for the navbar.
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String main(Model model) {
           // fill this portion i
    	model.addAttribute("products", productService.findAll());
    	model.addAttribute("brands", productService.findDistinctBrands());
    	model.addAttribute("categories", productService.findDistinctCategories());
    	return "main";
	   }

    @ModelAttribute("products")
    public List<Product> products(Model model) {
    	List<Product> product = (List<Product>) model.addAttribute("products", productService.findAll());
		return product;
           // fill this portion in
    }

    @ModelAttribute("categories")
    public List<String> categories() {
		return null;
           // fill this portion in
    }

    @ModelAttribute("brands")
    public List<String> brands() {
		return null;
           // fill this portion in
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(required = false) String category,
                         @RequestParam(required = false) String brand,
                         Model model) {
        List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
        model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
        return "main";
    }

    @GetMapping("/about")
    public String about() {
          // fill this portion in
    	return "About";
    }
}

