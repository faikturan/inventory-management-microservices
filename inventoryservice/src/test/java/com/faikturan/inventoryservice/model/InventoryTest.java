package com.faikturan.inventoryservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testGettersAndSetters() {
        // Positive test case
        Inventory inventory = new Inventory();
        inventory.setId(1L);
        inventory.setSkuCode("SKU123");
        inventory.setQuantity(10);

        Assertions.assertEquals(1L, inventory.getId());
        Assertions.assertEquals("SKU123", inventory.getSkuCode());
        Assertions.assertEquals(10, inventory.getQuantity());
    }

    @Test
    public void testEmptyConstructor() {
        // Positive test case
        Inventory inventory = new Inventory();

        Assertions.assertNull(inventory.getId());
        Assertions.assertNull(inventory.getSkuCode());
        Assertions.assertNull(inventory.getQuantity());
    }

    @Test
    public void testAllArgsConstructor() {
        // Positive test case
        Inventory inventory = new Inventory(1L, "SKU123", 10);

        Assertions.assertEquals(1L, inventory.getId());
        Assertions.assertEquals("SKU123", inventory.getSkuCode());
        Assertions.assertEquals(10, inventory.getQuantity());
    }

    @Test
    public void testRequiredArgsConstructor() {
        // Positive test case
      Inventory inventory = Inventory.builder()
        .skuCode("SKU123")
        .quantity(10)
        .build();
        Assertions.assertNull(inventory.getId());
        Assertions.assertEquals("SKU123", inventory.getSkuCode());
        Assertions.assertEquals(10, inventory.getQuantity());
    }
}