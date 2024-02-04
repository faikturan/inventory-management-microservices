package com.faikturan.orderservice.controller;

import com.faikturan.orderservice.dto.OrderRequest;
import com.faikturan.orderservice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderController = new OrderController(orderService);
    }

    @Test
    void placeOrder_shouldReturnSuccessMessage() {
        // Arrange
        OrderRequest orderRequest = new OrderRequest();
        // ... set up orderRequest with necessary data

        // Act
        String result = orderController.placeOrder(orderRequest);

        // Assert
        assertEquals("Order Placed Successfully", result);
        verify(orderService, times(1)).placeOrder(orderRequest);
    }
}