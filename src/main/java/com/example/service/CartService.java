package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Product;
import com.example.model.User;

public class CartService {

	@Autowired
	private ProductService productService;

	public User addProductToCart(User cart, Long productId, Integer quantity) {
		Product productToAdd = productService.findById(productId);
		HashMap<Product, Integer> newItem = new HashMap<>();
		newItem.put(productToAdd, quantity);
		List<HashMap<Product, Integer>> cartLineItems = cart.getCart();
		cartLineItems.add(newItem);
		cart.setCart(cartLineItems);
		return cart;
	}

    public User updateLineQuantities(User cart, Long id, Integer quantity) {
    	Product productToUpdate = productService.findById(id);
    	List<HashMap<Product, Integer>> cartItems = cart.getCart();
    	for(HashMap<Product, Integer> cartItem : cartItems) {
    		cartItem.replace(productToUpdate, quantity);
    	}
		cart.setCart(cartItems);
		return cart;
	}
}
