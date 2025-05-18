package org.skypro.skyshop.product;

public class Product {
    private final String productDesignation;
    private final int price;

    public Product(String productDesignation, int price) {
        this.productDesignation = productDesignation;
        this.price = price;
    }

    public String getProductDesignation() {
        return productDesignation;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return getProductDesignation() + ": " + getPrice();
    }
}

