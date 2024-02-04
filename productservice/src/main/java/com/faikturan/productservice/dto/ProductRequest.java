package com.faikturan.productservice.dto;

import com.faikturan.productservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private Category category;

    public ProductRequest(String testProduct, double v) {
    }

    public void setCategory(String testCategory) {
    }
}