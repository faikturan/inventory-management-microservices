package com.faikturan.inventoryservice.controller;

import com.faikturan.inventoryservice.dto.InventoryResponse;
import com.faikturan.inventoryservice.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    @Test
    void isInStock_ShouldReturnInventoryResponseList() {
        // Arrange
        List<String> skuCodes = Arrays.asList("SKU001", "SKU002");
        List<InventoryResponse> mockResponse = Arrays.asList(
                new InventoryResponse("SKU001", true),
                new InventoryResponse("SKU002", false)
        );
        when(inventoryService.isInStock(skuCodes)).thenReturn(mockResponse);

        // Act
        List<InventoryResponse> result = inventoryController.isInStock(skuCodes);

        // Assert
        assertEquals(2, result.size());
        assertEquals(mockResponse, result);
    }
}

