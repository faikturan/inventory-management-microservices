package com.faikturan.inventoryservice.dto;

import org.junit.Assert;
import org.junit.Test;

public class InventoryResponseTest {

    @Test
    public void testGetSkuCode() {
        InventoryResponse response = InventoryResponse.builder().skuCode("ABC123").build();
        Assert.assertEquals("ABC123", response.getSkuCode());
    }

    @Test
    public void testIsInStock() {
        InventoryResponse response = InventoryResponse.builder().isInStock(true).build();
        Assert.assertTrue(response.isInStock());
    }
}
