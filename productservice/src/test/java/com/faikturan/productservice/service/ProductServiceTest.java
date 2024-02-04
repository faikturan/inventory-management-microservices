package com.faikturan.productservice.service;

import com.faikturan.productservice.dto.ProductRequest;
import com.faikturan.productservice.dto.ProductResponse;
import com.faikturan.productservice.model.Product;
import com.faikturan.productservice.repository.ProductRepository;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateProduct() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Test Product");
        productRequest.setDescription("Test Description");
        productRequest.setPrice(10.0);
        productRequest.setCategory("Test Category");

        productService.createProduct(productRequest);

        verify(productRepository, times(1)).save(any(Product.class));
    }


    @Test
    public void testDeleteProduct() {
        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void getAllProduct_ShouldReturnProductResponseList() {
        // Arrange
        Product product = new Product();
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));

        // Act
        List<ProductResponse> result = productService.getAllProduct();

        // Assert
        assertEquals(1, result.size());
        // Add more assertions if needed
    }

    @Test
    void getProductById_ExistingId_ShouldReturnProduct() {
        // Arrange
        Long productId = 1L;
        Product mockProduct = new Product();
        when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(mockProduct));

        // Act
        Product result = productService.getProductById(productId);

        // Assert
        assertEquals(mockProduct, result);
        // Add more assertions if needed
    }

}
