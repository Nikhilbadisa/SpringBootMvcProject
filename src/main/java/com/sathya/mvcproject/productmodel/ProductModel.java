package com.sathya.mvcproject.productmodel;

import org.hibernate.validator.constraints.NotBlank;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private Long id;

	@NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	
	private String name;
    private int quantity;
    private double price;
	private String brand;
	private String madein;
	private double totalAmount;
	private double taxAmount;
	private String createdBy;

}
