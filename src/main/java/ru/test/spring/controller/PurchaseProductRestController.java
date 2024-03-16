package ru.test.spring.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.spring.model.PurchaseResponse;
import ru.test.spring.model.dto.ProductPurchaseDto;
import ru.test.spring.repository.ProductPurchaseRepository;

@RestController
@RequestMapping("api/v1/purchase")
public class PurchaseProductRestController {

    private final ProductPurchaseRepository productPurchaseRepository;

    public PurchaseProductRestController(ProductPurchaseRepository productPurchaseRepository) {
        this.productPurchaseRepository = productPurchaseRepository;
    }


    @GetMapping("/buy")
    public ResponseEntity<PurchaseResponse> buyProduct(@RequestBody ProductPurchaseDto productPurchaseDto) {
        return ResponseEntity.ok(productPurchaseRepository.buyProduct(productPurchaseDto));
    }
}
