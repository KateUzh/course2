package org.skypro.skyshop.product;

public abstract class Product {
    private final String productDesignation;

    public Product(String productDesignation) {
        this.productDesignation = productDesignation;
    }

    public String getProductDesignation() {
        return productDesignation;
    }

    public abstract int getPrice();

    public String toString() {
        return getProductDesignation() + ": " + getPrice();
    }

    public abstract boolean isSpecial();
}

