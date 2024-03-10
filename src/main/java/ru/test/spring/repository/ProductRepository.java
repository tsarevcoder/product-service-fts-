package ru.test.spring.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.test.spring.expection.ProductNotFoundExpection;
import ru.test.spring.model.ProductModel;

import java.util.List;

@Repository
public class ProductRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<?> addProduct(String title) {
        String sql = "INSERT INTO public.product (title) VALUES (?)";
        return ResponseEntity.ok(jdbcTemplate.update(sql,title));
    }


    public ResponseEntity<List<ProductModel>> getAllProducts() {
        String sql = "SELECT id,title FROM public.product";
        List<ProductModel> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductModel.class));
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<ProductModel> findById(Long id) {
        String sql = "SELECT * FROM public.product WHERE id = ?";
        try {
            ProductModel productModel = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(ProductModel.class),id);
            return ResponseEntity.ok(productModel);
        } catch (EmptyResultDataAccessException exception) {
            throw new ProductNotFoundExpection(id);
        }
    }
}
