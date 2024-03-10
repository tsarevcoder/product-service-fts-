package ru.test.spring.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import ru.test.spring.model.*;
import ru.test.spring.model.dto.ProductPurchaseDto;
import ru.test.spring.repository.ProductPurchaseRepository;

@Service
public class ProductPurchaseRepositoryImpl implements ProductPurchaseRepository {
    private final JdbcClient jdbcClient;
    
    public ProductPurchaseRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    @Override
    public ResponseEntity<PurchaseResponse> buyProduct(ProductPurchaseDto productPurchaseDto) {
        try {
            int userBalance = jdbcClient.sql("SELECT user_balance FROM public.user_account WHERE user_name = ?")
                    .param(productPurchaseDto.userName())
                    .query(Integer.class)
                    .single();
            int productPrice = jdbcClient.sql("SELECT price FROM public.product WHERE id = ?")
                    .param(productPurchaseDto.productId())
                    .query(Integer.class)
                    .single();
            if (userBalance >= productPrice) {
                int finalBalance = userBalance - productPrice;
                deletePurchasedProduct(productPurchaseDto.productId());
                updateUserBalance(finalBalance);
                return ResponseEntity.ok(new PurchaseResponse("You hase successfully purchased the product"));
            }
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.badRequest().body(new PurchaseResponse("id or user not found"));
        }
        return ResponseEntity
                .badRequest()
                .body(new PurchaseResponse("You dont have enough money"));
    }
    @Override
    public void updateUserBalance(int finalUserBalance) {
        jdbcClient.sql("UPDATE public.user_account SET user_balance = ?")
                .param(finalUserBalance)
                .update();
    }
    @Override
    public void deletePurchasedProduct(int productId) {
        jdbcClient.sql("DELETE FROM public.product WHERE id = ?")
                .param(productId)
                .update();
    }
}
