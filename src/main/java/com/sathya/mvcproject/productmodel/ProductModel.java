package com.sathya.mvcproject.productmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private String name;
	private double price;
	private int quantity;
	private String brand;
	private String madein;
	private double totalAmount;
	private double taxAmount;
	private String createdBy;

}
