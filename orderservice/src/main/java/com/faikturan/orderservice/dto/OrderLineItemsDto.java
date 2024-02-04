package com.faikturan.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private double price;
    private Integer quantity;

    public OrderLineItemsDto(String skuCode, double price) {
        this.skuCode = skuCode;
        this.price = price;
    }
}
