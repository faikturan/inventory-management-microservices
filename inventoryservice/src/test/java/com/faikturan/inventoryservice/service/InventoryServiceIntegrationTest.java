package com.faikturan.inventoryservice.service;

/*
For integration testing, you can use SpringBootTest
to test the interactions between the service and the actual database.
 */
import com.faikturan.inventoryservice.dto.InventoryResponse;
import com.faikturan.inventoryservice.model.Inventory;
import com.faikturan.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext
@Transactional
class InventoryServiceIntegrationTest {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    void isInStock_ShouldReturnInventoryResponseList() {
        // Arrange
        List<String> skuCodes = Arrays.asList("SKU001", "SKU002");
        inventoryRepository.saveAll(Arrays.asList(
                new Inventory("SKU001", 5),
                new Inventory("SKU002", 0)
        ));

        // Act
        List<InventoryResponse> result = inventoryService.isInStock(skuCodes);

        // Assert
        assertEquals(2, result.size());
        assertEquals("SKU001", result.get(0).getSkuCode());
        assertEquals(true, result.get(0).isInStock());
        assertEquals("SKU002", result.get(1).getSkuCode());
        assertEquals(false, result.get(1).isInStock());
        // Add more assertions if needed
    }

}
