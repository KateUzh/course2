package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("молоко", 100);
        Product banana = new Product("банан", 50);
        Product chocolate = new Product("шоколад", 150);
        Product carrot = new Product("морковь", 30);
        Product blueberry = new Product("черника", 220);
        Product chicken = new Product("курица", 350);

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