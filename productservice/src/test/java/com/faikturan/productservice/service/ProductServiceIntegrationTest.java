package com.faikturan.productservice.service;
import com.faikturan.productservice.dto.ProductRequest;
import com.faikturan.productservice.model.Product;
import com.faikturan.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
For integration testing, you can use SpringBootTest
to test the interactions between the service and the actual database.
 */
@SpringBootTest
@DirtiesContext
@Transactional
class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getAllProducts_ShouldReturnAllProductsFromDatabase() {
        // Arrange
        Product product1 = new Product();
        productRepository.save(product1);

        Product product2 = new Product();
        productRepository.save(product2);

        // Act
        List<Product> result = productService.getAllProducts();

        // Assert
        assertEquals(2, result.size());
        // Add more assertions if needed
    }

    @Test
    void createProduct_ShouldSaveProductToDatabase() {
        // Arrange
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Test Product");
        productRequest.setDescription("Test Description");
        productRequest.setPrice(50.0);
        productRequest.setCategory("Test Category");

        // Act
        productService.createProduct(productRequest);

        // Assert
        assertEquals(1, productService.getAllProducts().size());
        // Add more assertions if needed
    }

}
