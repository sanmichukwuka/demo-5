package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;
import com.example.model.User;
import com.example.service.CartService;
import com.example.service.ProductService;
import com.example.service.UserService;

@Controller
@ControllerAdvice
public class CartController {
  @Autowired
  ProductService productService;

  @Autowired
  UserService userService;
  
  @Autowired
  CartService cartService;

  @ModelAttribute("loggedInUser")
  public User loggedInUser() {
//	  User user = new User(userName, passWord);
	return null;
  	  // fill this portion in
  }

  @ModelAttribute("cart")
  public Map<Product, Integer> cart() {
	return null;
      // fill this portion in
  }
  
  /**
   * Puts an empty list in the model that thymeleaf can use to sum up the cart total.
   */
  @ModelAttribute("list")
  public List<Double> list() {
      return new ArrayList<>();
  }

  @GetMapping("/cart")
  public String showCart() {
      return "cart";
  }

  @PostMapping("/cart")
  public String addToCart(@RequestParam long productId, User cart, Integer quantity, Model model) {
  // fill this portion in
	  cartService.addProductToCart(cart, productId, quantity);
	  model.addAttribute("cart", cart);
	  return "cart";
  }

  @PatchMapping("/cart")
  public String updateQuantities(@RequestParam long[] id, @RequestParam int[] quantity, User cart) {
      // fill this portion in
	  for(int i = 0; i < id.length; i++) {
		  Product product = productService.findById(id[i]);
//		  cartService.updateLineQuantities(cart, id, quantity);
	  }
	  
      return "cart";
  }
  
	@DeleteMapping("/cart")
    public String removeFromCart(@RequestParam long id) {
		return null;
		// fill this portion in
    }

    private void setQuantity(Product p, int quantity) {
		// fill this portion in
  }
}