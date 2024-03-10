package ru.test.spring.repository;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.test.spring.model.*;
import ru.test.spring.model.dto.ProductPurchaseDto;


@Repository
public interface ProductPurchaseRepository {


    ResponseEntity<PurchaseResponse> buyProduct(ProductPurchaseDto productPurchaseDto);

    void updateUserBalance(int finalUserBalance);

    void deletePurchasedProduct(int productId);
}
