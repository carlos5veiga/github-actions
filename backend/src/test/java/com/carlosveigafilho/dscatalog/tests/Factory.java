package com.carlosveigafilho.dscatalog.tests;

import java.time.Instant;

import com.carlosveigafilho.dscatalog.entities.Category;
import com.carlosveigafilho.dscatalog.entities.Product;

public class Factory {

	public static Product createProduct() {
		Product product = new Product(1L, "Test PC", "Test Description", 40.00, "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg", Instant.now());
		product.getCategories().add(new Category(2L, "Electronics"));
		return product;
	}
}
