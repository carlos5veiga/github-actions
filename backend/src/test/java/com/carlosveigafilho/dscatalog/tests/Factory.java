package com.carlosveigafilho.dscatalog.tests;

import java.time.Instant;

import com.carlosveigafilho.dscatalog.dto.ProductDTO;
import com.carlosveigafilho.dscatalog.entities.Category;
import com.carlosveigafilho.dscatalog.entities.Product;

public class Factory {

	public static Product createProduct() {
		Product product = new Product(1L, "Test PC", "Test Description", 40.00, "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg", Instant.now());
		product.getCategories().add(createCategory());
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product, product.getCategories());
	}
	
	public static Category createCategory() {
		return new Category(2L, "Electronics");
	}
}
