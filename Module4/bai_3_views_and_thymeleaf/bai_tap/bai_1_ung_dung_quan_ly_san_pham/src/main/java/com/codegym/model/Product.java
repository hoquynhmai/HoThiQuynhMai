package com.codegym.model;

public class Product {
    private int id;
    private String nameProduct;
    private String typeOfProduct;
    private String producerOfProduct;

    public Product() {
    }

    public Product(int id, String nameProduct, String typeOfProduct, String producerOfProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.typeOfProduct = typeOfProduct;
        this.producerOfProduct = producerOfProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public String getProducerOfProduct() {
        return producerOfProduct;
    }

    public void setProducerOfProduct(String producerOfProduct) {
        this.producerOfProduct = producerOfProduct;
    }
}
