package ru.test.spring.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.spring.model.ProductModel;
import ru.test.spring.model.dto.ProductDto;
import ru.test.spring.repository.ProductRepository;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productRepository.addProduct(productDto.title()));
    }


    @GetMapping("/getproducts")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id) {
        return productRepository.findById(id);
    }
}

