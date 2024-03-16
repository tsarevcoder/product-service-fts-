package ru.test.spring.service;

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
    public PurchaseResponse buyProduct(ProductPurchaseDto productPurchaseDto) {
        int userBalance = jdbcClient.sql("SELECT user_balance FROM public.user_account WHERE user_name = ?")
                .param(productPurchaseDto.userName())
                .query(Integer.class)
                .single();
        int productPrice = jdbcClient.sql("SELECT price FROM public.product WHERE id = ?")
                .param(productPurchaseDto.productId())
                .query(Integer.class)
                .single();
        if (userBalance >= productPrice) {
            int finalBalance = userBalance - productPrice; // user balance after purchase
            deletePurchasedProduct(productPurchaseDto.productId());
            updateUserBalance(finalBalance);
            return new PurchaseResponse("you bought the product");
        }
        return new PurchaseResponse("you have no money");
    }

    @Override
    public void updateUserBalance(int finalUserBalance) {
        String sql = "UPDATE public.user_account SET user_balance = ?";
        jdbcClient.sql(sql)
                .param(finalUserBalance)
                .update();
    }
    @Override
    public void deletePurchasedProduct(int productId) {
        String sql = "DELETE FROM public.product WHERE id = ?";
        jdbcClient.sql(sql)
                .param(productId)
                .update();
    }
}
