package com.faikturan.inventoryservice.controller;

import com.faikturan.inventoryservice.dto.InventoryResponse;
import com.faikturan.inventoryservice.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@DirtiesContext
@Transactional
class InventoryControllerIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private InventoryService inventoryService;

    @Test
    void isInStock_ShouldReturnInventoryResponseList() throws Exception {
        // Arrange
        List<String> skuCodes = Arrays.asList("SKU001", "SKU002");
        List<InventoryResponse> mockResponse = Arrays.asList(
                new InventoryResponse("SKU001", true),
                new InventoryResponse("SKU002", false)
        );

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/inventory")
                        .param("skuCode", "SKU001", "SKU002")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{'skuCode':'SKU001','isInStock':true}," +
                        "{'skuCode':'SKU002','isInStock':false}]"));
    }

}

