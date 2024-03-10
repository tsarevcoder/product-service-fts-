package ru.test.spring.expection;



public class ProductNotFoundExpection extends RuntimeException {


    public ProductNotFoundExpection(Long id) {
        super("Product with id %s not found".formatted(id));
    }
}
