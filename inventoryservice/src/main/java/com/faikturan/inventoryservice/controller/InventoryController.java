package com.faikturan.inventoryservice.controller;

import com.faikturan.inventoryservice.dto.InventoryResponse;
import com.faikturan.inventoryservice.service.InventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Inventory", description = "the Inventory Api")
@RestController
@RequestMapping(value = "api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
