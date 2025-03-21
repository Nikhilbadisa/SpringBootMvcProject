package com.sathya.mvcproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.sathya.mvcproject.entity.Product;
import com.sathya.mvcproject.productmodel.ProductModel;
import com.sathya.mvcproject.repository.ProductRepository;
import com.sathya.mvcproject.service.ProductService;

import jakarta.validation.Valid;
import lombok.With;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProductController {

     
 @Autowired
 ProductService productService;


	/*
	 * @GetMapping("/Nikhil") public String message() { return "Productform"; }
	 * 
	 */


	
	  @GetMapping("/Nikhilform") 
	  public String getMessage(Model model) 
	  {
	  Product product = new Product(); 
	  product.setPrice(100); model.addAttribute("product",product);  
	  return "Productform"; 
	  }
	 
      @PostMapping("/SaveProduct")
      public String savepProductData(@Valid @ModelAttribute("product") ProductModel productModel,BindingResult bindingResult) {
    	  if(bindingResult.hasErrors()) {
    		return "Productform"; 
    	  }
          productService.saveProduct(productModel);
          return "Success";
      }
      
      @GetMapping("/ViewProducts")
      public String viewDetail(Model model) {
    	  List<Product> products=productService.viewDetails();
    	  model.addAttribute("products",products);
          return "View";
      }
      
      @GetMapping("/viewProduct/{id}")
      public String getProductById(@PathVariable Long id,Model model) {
    	  Optional<Product> optional=productService.getProductById(id);
    	  
    	  if(optional.isPresent()) {
    		  Product product=optional.get();
    		  model.addAttribute("product",product);
    	  }
    	  else {
    		  model.addAttribute("errormessage","Product with Id "+id+" not found");
    	  }
    	  
          return "ProductById";
      }
      
      @GetMapping("/deleteProduct/{id}")
      public String deleteProductById(@PathVariable("id") Long id,Model model) {
    	  productService.deleteProductById(id);
    	  
          return "redirect:/ViewProducts";
      }
      
      @GetMapping("/editProduct/{id}")
      public String geteditProductById(@PathVariable("id") Long id,Model model) {
    	  ProductModel productModel=productService.geteditProductById(id);
    	  model.addAttribute("ProductModel",productModel);
          return "editProduct";
      }
      
      @GetMapping("/UpdateProduct/{id}")
      public String getMethodName(@RequestParam String param) {
          return new String();
      }
      
      
      
      
}
