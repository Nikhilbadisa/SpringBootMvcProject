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
    private ProductRepository productRepository;

    // Save product
    public void saveProduct(ProductModel productModel) {
        Product product = new Product();
        product.setName(productModel.getName());
        product.setQuantity(productModel.getQuantity());
        product.setPrice(productModel.getPrice());
        product.setMadein(productModel.getMadein());
        productRepository.save(product);
    }

    // View all products
    public List<Product> viewDetails() {
        return productRepository.findAll();
    }

    // Get product by ID (Optional)
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Get product by ID and return ProductModel
    public ProductModel getEditProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Convert entity to model
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setQuantity(product.getQuantity());
        productModel.setPrice(product.getPrice());
        productModel.setMadein(product.getMadein());

        return productModel;
    }

    // Delete product by ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // Update product by ID
    public void updateProductById(Long id, ProductModel productModel) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setName(productModel.getName());
        product.setQuantity(productModel.getQuantity());
        product.setPrice(productModel.getPrice());
        product.setMadein(productModel.getMadein());
        productRepository.save(product);
    }
}
