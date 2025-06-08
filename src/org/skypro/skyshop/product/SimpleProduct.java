package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String productDesignation, int price) {
        super(productDesignation);
        if (price <= 0) {
            throw new IllegalArgumentException("Недопустимое значение цены!");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
