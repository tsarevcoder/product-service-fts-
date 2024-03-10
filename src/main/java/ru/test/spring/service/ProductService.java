package ru.test.spring.service;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import ru.test.spring.expection.ProductNotFoundExpection;
import ru.test.spring.model.ProductModel;
import ru.test.spring.model.ProductRowMapper;
import ru.test.spring.model.dto.ProductDto;
import ru.test.spring.repository.ProductRepositoryV2;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService implements ProductRepositoryV2  {


    private final JdbcClient jdbcClient;

    public ProductService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<ProductModel> findAllProducts() {
        return jdbcClient.sql("SELECT * FROM public.product")
                .query(new ProductRowMapper())
                .list();
    }
    @Override
    public Optional<ProductModel> findById(Long id) {
        return jdbcClient.sql("SELECT * FROM public.product WHERE id = ?")
                .param(id)
                .query(new ProductRowMapper())
                .optional();
    }
    
    @Override
    public ResponseEntity<?> addProduct(ProductDto productDto) {
        return ResponseEntity.ok(jdbcClient.sql("INSERT INTO public.product (title) VALUES (?)").param(productDto.title()).update());
    }
}
