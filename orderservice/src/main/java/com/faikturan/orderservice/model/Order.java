package com.faikturan.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import static jakarta.persistence.CascadeType.ALL;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = ALL)
    private List<OrderLineItems> orderLineItemsList;
}
