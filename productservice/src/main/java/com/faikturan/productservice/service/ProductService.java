package com.faikturan.productservice.service;

import com.faikturan.productservice.dto.ProductRequest;
import com.faikturan.productservice.dto.ProductResponse;
import com.faikturan.productservice.model.Product;
import com.faikturan.productservice.repository.ProductRepository;
import jakarta.ws.rs.NotFoundException;
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

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll().stream().map(
                this::mapProductToProductResponse).toList();
    }

    public ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(String.valueOf(product.getId()))
                .name(product.getName())
                .description(product.getDescription())
                .price(BigDecimal.valueOf(product.getPrice()))
                .category(product.getCategory())
                .build();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + productId));
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        // Add business logic if needed
        Product existingProduct = getProductById(productId);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long productId) {
        // Add business logic if needed
        productRepository.deleteById(productId);
    }

    public double calculateTotalValue() {
        List<Product> products = getAllProducts();
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
