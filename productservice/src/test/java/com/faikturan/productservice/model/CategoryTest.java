package com.faikturan.productservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testCategoryConstructor() {
        Category category = new Category(1L, "Test Category");
        assertEquals(1L, category.getId());
        assertEquals("Test Category", category.getName());
    }

    @Test
    void testCategorySettersAndGetters() {
        Category category = new Category();
        category.setId(2L);
        category.setName("New Category");
        assertEquals(2L, category.getId());
        assertEquals("New Category", category.getName());
    }
}
