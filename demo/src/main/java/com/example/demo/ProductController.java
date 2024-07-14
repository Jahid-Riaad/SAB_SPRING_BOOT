package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws GlobalException {
        logger.info("Fetching product with ID: " + id);
        Product product = findProductById(id);
        if (product == null) {
            logger.error("Product not found with ID: " + id);
            ProductNotFoundException.throwException("Product not found with ID: " + id);
        }
        return ResponseEntity.ok(product);
    }

    private Product findProductById(Long id) {
        if (id != 1) {
            return null;
        }
        return new Product(1L, "Sample Product");
    }
}
