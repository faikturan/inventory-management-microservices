package com.faikturan.productservice.dto;

import com.faikturan.productservice.model.Category;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private Category category;

    public ProductResponse(long l, String s, double v) {
    }
}