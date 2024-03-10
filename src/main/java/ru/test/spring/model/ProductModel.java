package ru.test.spring.model;



public class ProductModel {


    private Long id;

    private String title;

    private int price;

    public ProductModel(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
