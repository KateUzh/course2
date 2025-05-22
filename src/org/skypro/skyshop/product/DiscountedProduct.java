package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    int basePrice;
    int discount;

    public DiscountedProduct(String productDesignation, int basePrice, int discount) {
        super(productDesignation);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount) / 100;
    }

    @Override
    public String toString() {
        return getProductDesignation() + ": " + basePrice + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
