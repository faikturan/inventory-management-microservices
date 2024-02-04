package com.faikturan.productservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        // Positive test case
        Category category = Category.builder().id(1L).name("Electronics").build();
        Product product = Product.builder().id(1L).name("Laptop").description("High-performance laptop").price(1000.0).category(category).build();

        Assertions.assertEquals(1L, product.getId());
        Assertions.assertEquals("Laptop", product.getName());
        Assertions.assertEquals("High-performance laptop", product.getDescription());
        Assertions.assertEquals(1000.0, product.getPrice());
        Assertions.assertEquals(category, product.getCategory());
    }

    @Test
    public void testNullCategory() {
        // Negative test case - category is null
        Product product = Product.builder().id(1L).name("Laptop").description("High-performance laptop").price(1000.0).category(null).build();

        Assertions.assertNull(product.getCategory());
    }
}