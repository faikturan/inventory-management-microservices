package com.faikturan.orderservice.service;

import com.faikturan.orderservice.dto.OrderLineItemsDto;
import com.faikturan.orderservice.model.OrderLineItems;
import com.faikturan.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private WebClient.Builder webClientBuilder;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository, webClientBuilder);
    }

    @Test
    void mapToOrderLineItems_ShouldMapOrderLineItemsDtoToOrderLineItems() {
        // Arrange
        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
        orderLineItemsDto.setId(1L);
        orderLineItemsDto.setSkuCode("SKU123");
        orderLineItemsDto.setPrice(10.0);
        orderLineItemsDto.setQuantity(2);

        // Act
        OrderLineItems orderLineItems = orderService.mapToOrderLineItems(orderLineItemsDto);

        // Assert
        assertNotNull(orderLineItems);
        assertEquals(orderLineItemsDto.getId(), orderLineItems.getId());
        assertEquals(orderLineItemsDto.getSkuCode(), orderLineItems.getSkuCode());
        assertEquals(orderLineItemsDto.getPrice(), orderLineItems.getPrice());
        assertEquals(orderLineItemsDto.getQuantity(), orderLineItems.getQuantity());
    }
}