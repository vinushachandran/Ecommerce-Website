package com.TinyTreasures.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.TinyTreasures.global.GlobalData;
import com.TinyTreasures.service.CategoryService;
import com.TinyTreasures.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProducts());
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "AllProductView";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model,@PathVariable int id) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProductsByCategoryID(id));
		return "AllProductView";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model,@PathVariable int id) {
		model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute("product",productService.getProductById(id).get());
		return "viewProduct";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "Contact";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "About";
	}

}
