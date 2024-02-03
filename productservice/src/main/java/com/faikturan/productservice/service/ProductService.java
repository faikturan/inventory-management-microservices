package com.faikturan.productservice.service;

import com.faikturan.productservice.dto.ProductRequest;
import com.faikturan.productservice.dto.ProductResponse;
import com.faikturan.productservice.model.Product;
import com.faikturan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .build();

        productRepository.save(product);
        log.info("Product {'id':'{}', 'name':'{}','description':'{}','price':'{}','category':'{}'} is Saved.",
                product.getId(), product.getName(), productRequest.getDescription(), productRequest.getPrice(),
                product.getCategory());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(
                this::mapProductToProductResponse).toList();
    }

    public ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(String.valueOf(product.getId()))
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }
}
