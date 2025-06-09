package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productDesignation, int basePrice, int discount) {
        super(productDesignation);
        if ((basePrice <= 0) || (discount < 0) || (discount > 100)) {
            throw new IllegalArgumentException("Недопустимое значение цены или скидки!");
        }
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
