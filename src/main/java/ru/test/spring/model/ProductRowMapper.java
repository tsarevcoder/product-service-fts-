package ru.test.spring.model;


import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductModel> {


    @Override
    public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductModel productModel = new ProductModel(rs.getLong("id"), rs.getString("title"), rs.getInt("price"));
        return productModel;
    }
}
