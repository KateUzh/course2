package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product milk = new SimpleProduct("молоко", 100);
        Product banana = new SimpleProduct("банан", 50);
        Product chocolate = new SimpleProduct("шоколад", 150);
        Product carrot = new DiscountedProduct("морковь", 30, 10);
        Product blueberry = new DiscountedProduct("черника", 220, 30);
        Product chicken = new FixPriceProduct("курица");

        ProductBasket productBasket1 = new ProductBasket();

        productBasket1.addProductInBasket(milk);
        productBasket1.addProductInBasket(chocolate);
        productBasket1.addProductInBasket(carrot);
        productBasket1.addProductInBasket(chicken);
        productBasket1.addProductInBasket(banana);
        productBasket1.addProductInBasket(blueberry);
        productBasket1.printBasket();
        System.out.println("\nСтоимость корзины " + productBasket1.calcTotalBasketCost());
        System.out.println("\nproductBasket1.checkProduct(\"курица\") = " +
                productBasket1.checkProduct("курица"));
        System.out.println("\nproductBasket1.checkProduct(\"черника\") = " +
                productBasket1.checkProduct("черника"));
        productBasket1.clearBasket();
        productBasket1.printBasket();
        System.out.println("\nСтоимость корзины " + productBasket1.calcTotalBasketCost());
        System.out.println("\nproductBasket1.checkProduct(\"курица\") = " +
                productBasket1.checkProduct("курица"));
        System.out.println("productBasket1 = " + productBasket1);
    }
}