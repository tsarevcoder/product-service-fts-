package ru.test.spring.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.spring.expection.ProductNotFoundExpection;
import ru.test.spring.model.ProductModel;
import ru.test.spring.model.dto.ProductDto;
import ru.test.spring.repository.ProductRepositoryV2;

import java.util.List;

@RestController
@RequestMapping("api/v2/products")
public class ProductRestControllerV2 {

    private final ProductRepositoryV2 productRepositoryV2;

    public ProductRestControllerV2(ProductRepositoryV2 productRepositoryV2) {
        this.productRepositoryV2 = productRepositoryV2;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> findAllProducts() {
        return ResponseEntity.ok(productRepositoryV2.findAllProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productRepositoryV2.findById(id).orElseThrow(() -> new ProductNotFoundExpection(id)));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productRepositoryV2.addProduct(productDto));
        // finish writing returns id and title added product
    }
}
