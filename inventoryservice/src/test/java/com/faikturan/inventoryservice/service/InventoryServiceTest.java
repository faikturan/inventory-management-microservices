package com.faikturan.inventoryservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.faikturan.inventoryservice.dto.InventoryResponse;
import com.faikturan.inventoryservice.model.Inventory;
import com.faikturan.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class InventoryServiceTest {
    private InventoryRepository inventoryRepository;
    private InventoryService inventoryService;

    @BeforeEach
    public void setup() {
        inventoryRepository = mock(InventoryRepository.class);
        inventoryService = new InventoryService(inventoryRepository);
    }

    @Test
    public void isInStock_WithValidSkus_ReturnsInventoryResponseList() {
        // Arrange
        List<String> skuCodes = Arrays.asList("SKU1", "SKU2");
        List<Inventory> inventories = Arrays.asList(
                new Inventory("SKU1", 10),
                new Inventory("SKU2", 0)
        );
        when(inventoryRepository.findBySkuCodeIn(skuCodes)).thenReturn(inventories);

        // Act
        List<InventoryResponse> response = inventoryService.isInStock(skuCodes);

        // Assert
        assertEquals(2, response.size());
        assertEquals("SKU1", response.get(0).getSkuCode());
        assertEquals(true, response.get(0).isInStock());
        assertEquals("SKU2", response.get(1).getSkuCode());
        assertEquals(false, response.get(1).isInStock());
    }

    @Test
    public void isInStock_WithEmptySkus_ReturnsEmptyInventoryResponseList() {
        // Arrange
        List<String> skuCodes = Arrays.asList();
        when(inventoryRepository.findBySkuCodeIn(skuCodes)).thenReturn(Arrays.asList());

        // Act
        List<InventoryResponse> response = inventoryService.isInStock(skuCodes);

        // Assert
        assertEquals(0, response.size());
    }
}