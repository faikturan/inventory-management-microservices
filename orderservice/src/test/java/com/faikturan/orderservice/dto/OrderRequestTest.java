package com.faikturan.orderservice.dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class OrderRequestTest {

    private OrderRequest orderRequest;
    private List<OrderLineItemsDto> orderLineItemsDtoList;

    @BeforeEach
    public void setup() {
        orderLineItemsDtoList = new ArrayList<>();
        orderRequest = new OrderRequest(orderLineItemsDtoList);
    }

    @Test
    public void testGetOrderLineItemsDtoList() {
        Assertions.assertEquals(orderLineItemsDtoList, orderRequest.getOrderLineItemsDtoList());
    }

    @Test
    public void testSetOrderLineItemsDtoList() {
        List<OrderLineItemsDto> newOrderLineItemsDtoList = new ArrayList<>();
        orderRequest.setOrderLineItemsDtoList(newOrderLineItemsDtoList);
        Assertions.assertEquals(newOrderLineItemsDtoList, orderRequest.getOrderLineItemsDtoList());
    }

    @Test
    public void testBuilder() {
        orderRequest = OrderRequest.builder()
                .orderLineItemsDtoList(orderLineItemsDtoList)
                .build();
        Assertions.assertEquals(orderLineItemsDtoList, orderRequest.getOrderLineItemsDtoList());
    }

    @Test
    public void testAllArgsConstructor() {
        orderRequest = new OrderRequest(orderLineItemsDtoList);
        Assertions.assertEquals(orderLineItemsDtoList, orderRequest.getOrderLineItemsDtoList());
    }

    @Test
    public void testRequiredArgsConstructor() {
        orderRequest = new OrderRequest();
        Assertions.assertNull(orderRequest.getOrderLineItemsDtoList());
    }
}