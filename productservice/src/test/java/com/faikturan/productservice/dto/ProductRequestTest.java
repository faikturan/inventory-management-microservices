package com.faikturan.productservice.dto;
import com.faikturan.productservice.model.Category;
import org.junit.Assert;
import org.junit.Test;

public class ProductRequestTest {

    @Test
    public void testGetName() {
        ProductRequest productRequest = ProductRequest.builder()
                .name("Test Product")
                .build();

        Assert.assertEquals("Test Product", productRequest.getName());
    }

    @Test
    public void testGetDescription() {
        ProductRequest productRequest = ProductRequest.builder()
                .description("Test Description")
                .build();

        Assert.assertEquals("Test Description", productRequest.getDescription());
    }

    @Test
    public void testGetPrice() {
        ProductRequest productRequest = ProductRequest.builder()
                .price(10.99)
                .build();

        Assert.assertEquals(10.99, productRequest.getPrice(), 0.001);
    }

    @Test
    public void testGetCategory() {
        Category category = new Category("Test Category");
        ProductRequest productRequest = ProductRequest.builder()
                .category(category)
                .build();

        Assert.assertEquals(category, productRequest.getCategory());
    }
}