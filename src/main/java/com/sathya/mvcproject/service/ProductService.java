package com.sathya.mvcproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.mvcproject.entity.Product;
import com.sathya.mvcproject.productmodel.ProductModel;
import com.sathya.mvcproject.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
ProductRepository productRepository;
public void saveProduct(ProductModel productModel) {
	Product product=new Product();
	product.setName(productModel.getName());
	product.setQuantity(productModel.getQuantity());
	product.setPrice(productModel.getPrice());
	 
	productRepository.save(product);
}

public List<Product> viewDetails()
{
	return productRepository.findAll();
}

public Optional<Product> getProductById(Long id)
{
	Optional<Product> product=productRepository.findById(id);
	return product;
}

public void deleteProductById(Long id)
{
	productRepository.deleteById(id);
}
 

public ProductModel geteditProductById(Long id) {
	Product product=productRepository.findById(id).get();
	
	ProductModel productModel=new ProductModel();
	productModel.setName(product.getName());
	productModel.setQuantity(product.getQuantity());
	productModel.setPrice(product.getPrice());
	
	return productModel;
}


}
