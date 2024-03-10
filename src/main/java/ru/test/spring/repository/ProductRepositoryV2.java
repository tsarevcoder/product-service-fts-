package ru.test.spring.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.test.spring.model.ProductModel;
import ru.test.spring.model.dto.ProductDto;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepositoryV2 {

    List<ProductModel> findAllProducts();

    Optional<ProductModel> findById(Long id);

    ResponseEntity<?> addProduct(ProductDto productDto);
}
