package com.faikturan.orderservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OrderLineItemsTest {

    @Test
    public void testGettersAndSetters() {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(1L);
        orderLineItems.setSkuCode("SKU123");
        orderLineItems.setPrice(10.0);
        orderLineItems.setQuantity(5);

        Assertions.assertEquals(1L, orderLineItems.getId());
        Assertions.assertEquals("SKU123", orderLineItems.getSkuCode());
        Assertions.assertEquals(10.0, orderLineItems.getPrice());
        Assertions.assertEquals(5, orderLineItems.getQuantity());
    }

    @Test
    public void testConstructorWithAllArgs() {
        OrderLineItems orderLineItems = new OrderLineItems(1L, "SKU123", 10.00, 5);

        Assertions.assertEquals(1L, orderLineItems.getId());
        Assertions.assertEquals("SKU123", orderLineItems.getSkuCode());
        Assertions.assertEquals(10.0, orderLineItems.getPrice());
        Assertions.assertEquals(5, orderLineItems.getQuantity());
    }

    @Test
    public void testConstructorWithRequiredArgs() {
        OrderLineItems orderLineItems = new OrderLineItems("SKU123", 10.00, 5);

        Assertions.assertNull(orderLineItems.getId());
        Assertions.assertEquals("SKU123", orderLineItems.getSkuCode());
        Assertions.assertEquals(10.0, orderLineItems.getPrice());
        Assertions.assertEquals(5, orderLineItems.getQuantity());
    }

    @Test
    public void testToString() {
        OrderLineItems orderLineItems = new OrderLineItems(1L, "SKU123", 10.00, 5);

        String expectedToString = "OrderLineItems(id=1, skuCode=SKU123, price=10.0, quantity=5)";

        Assertions.assertEquals(expectedToString, orderLineItems.toString());
    }
}