package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String productDesignation) {
        super(productDesignation);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    public String toString() {
        return getProductDesignation() + ": Фиксированная цена " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
