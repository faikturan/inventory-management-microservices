package com.faikturan.productservice.controller;

import com.faikturan.productservice.dto.ProductRequest;
import com.faikturan.productservice.dto.ProductResponse;
import com.faikturan.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productService);
    }

    @Test
    void addProduct_PositiveTest() {
        ProductRequest productRequest = new ProductRequest("Test Product", 10.0);
        ResponseEntity<Void> expectedResponse = new ResponseEntity<>(HttpStatus.CREATED);

        productController.addProduct(productRequest);

        verify(productService, times(1)).createProduct(productRequest);
        assertEquals(expectedResponse.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void getAllProducts_PositiveTest() {
        List<ProductResponse> expectedResponse = Arrays.asList(
                new ProductResponse(1L, "Product 1", 10.0),
                new ProductResponse(2L, "Product 2", 20.0)
        );
        when(productService.getAllProduct()).thenReturn(expectedResponse);

        List<ProductResponse> actualResponse = productController.getAllProducts();

        verify(productService, times(1)).getAllProduct();
        assertEquals(expectedResponse.size(), actualResponse.size());
        assertEquals(expectedResponse.get(0).getName(), actualResponse.get(0).getName());
        assertEquals(expectedResponse.get(0).getPrice(), actualResponse.get(0).getPrice());
        assertEquals(expectedResponse.get(1).getName(), actualResponse.get(1).getName());
        assertEquals(expectedResponse.get(1).getPrice(), actualResponse.get(1).getPrice());
    }
}