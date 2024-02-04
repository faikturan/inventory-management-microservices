package com.faikturan.orderservice.dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OrderLineItemsDtoTest {

    @Test
    public void testGettersAndSetters() {
        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
        orderLineItemsDto.setId(1L);
        orderLineItemsDto.setSkuCode("ABC123");
        orderLineItemsDto.setPrice(10.0);
        orderLineItemsDto.setQuantity(5);

        Assertions.assertEquals(1L, orderLineItemsDto.getId());
        Assertions.assertEquals("ABC123", orderLineItemsDto.getSkuCode());
        Assertions.assertEquals(10.0, orderLineItemsDto.getPrice());
        Assertions.assertEquals(5, orderLineItemsDto.getQuantity());
    }

    @Test
    public void testAllArgsConstructor() {
        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto(1L, "ABC123", 10.0, 5);

        Assertions.assertEquals(1L, orderLineItemsDto.getId());
        Assertions.assertEquals("ABC123", orderLineItemsDto.getSkuCode());
        Assertions.assertEquals(10.0, orderLineItemsDto.getPrice());
        Assertions.assertEquals(5, orderLineItemsDto.getQuantity());
    }

    @Test
    public void testRequiredArgsConstructor() {
        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto("ABC123", 10.0);

        Assertions.assertNull(orderLineItemsDto.getId());
        Assertions.assertEquals("ABC123", orderLineItemsDto.getSkuCode());
        Assertions.assertEquals(10.0, orderLineItemsDto.getPrice());
        Assertions.assertNull(orderLineItemsDto.getQuantity());
    }
}