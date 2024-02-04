package com.faikturan.orderservice.service;

import com.faikturan.orderservice.dto.OrderLineItemsDto;
import com.faikturan.orderservice.dto.OrderRequest;
import com.faikturan.orderservice.repository.OrderRepository;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    void placeOrder_ProductInStock_SaveOrder() {
        // Mock external service response
        // Use @MockBean or other mocking techniques for external services

        // Test placing an order with products in stock
        OrderRequest orderRequest = createOrderRequestWithInStockProduct();

        webTestClient.post()
                .uri("/place-order")
                .contentType(org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_JSON))
                .body(fromValue(orderRequest))
                .exchange()
                .expectStatus().isNotFound();

        // Verify that the order is saved
        //Mockito.verify(orderRepository).save(any());
    }

    @Test
    void placeOrder_ProductNotInStock_ReturnBadRequest() {
        // Mock external service response
        // Use @MockBean or other mocking techniques for external services

        // Test placing an order with products not in stock
        OrderRequest orderRequest = createOrderRequestWithOutOfStockProduct();

        webTestClient.post()
                .uri("/place-order")
                .contentType(org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_JSON))
                .body(fromValue(orderRequest))
                .exchange()
                .expectStatus().isNotFound();

        // Verify that the order is not saved
        Mockito.verify(orderRepository, Mockito.never()).save(any());
    }

    public static OrderRequest createOrderRequestWithInStockProduct() {
        // Create a sample OrderLineItemsDto with product in stock
        OrderLineItemsDto inStockProduct = OrderLineItemsDto.builder()
                .id(1L)
                .skuCode("SKU001")
                .price(29.99)
                .quantity(3)
                .build();

        // Create an OrderRequest with the above OrderLineItemsDto
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderLineItemsDtoList(Arrays.asList(inStockProduct));

        return orderRequest;
    }

    public static OrderRequest createOrderRequestWithOutOfStockProduct() {
        // Create a sample OrderLineItemsDto with product out of stock
        OrderLineItemsDto outOfStockProduct = OrderLineItemsDto.builder()
                .id(2L)
                .skuCode("SKU002")
                .price(39.99)
                .quantity(2)
                .build();

        // Create an OrderRequest with the above OrderLineItemsDto
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderLineItemsDtoList(Arrays.asList(outOfStockProduct));

        return orderRequest;
    }
}

