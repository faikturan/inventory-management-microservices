package com.faikturan.orderservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testGetId() {
        Order order = new Order();
        order.setId(1L);
        assertEquals(1L, order.getId());
    }

    @Test
    public void testGetOrderNumber() {
        Order order = new Order();
        order.setOrderNumber("12345");
        assertEquals("12345", order.getOrderNumber());
    }

    @Test
    public void testGetOrderLineItemsList() {
        Order order = new Order();
        OrderLineItems item1 = new OrderLineItems();
        OrderLineItems item2 = new OrderLineItems();
        order.getOrderLineItemsList().add(item1);
        order.getOrderLineItemsList().add(item2);
        assertEquals(2, order.getOrderLineItemsList().size());
    }

    @Test
    public void testGetOrderLineItemsList_Empty() {
        Order order = new Order();
        assertEquals(0, order.getOrderLineItemsList().size());
    }
}
