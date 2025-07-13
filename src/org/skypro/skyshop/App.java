package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        Product milk = new SimpleProduct("молоко", 100);
        Product banana = new SimpleProduct("банан", 50);
        Product chocolate = new SimpleProduct("шоколад", 150);
        Product carrot = new DiscountedProduct("морковь", 30, 30);
        Product blueberry = new DiscountedProduct("черника", 220, 30);
        Product chicken = new FixPriceProduct("курица");
        Article blackTeaArticle = new Article("Чай", "Чёрный крупнолистовой чай без добавок");
        Article greenTeaArticle = new Article("Чай", "Зелёный крупнолистовой чай без добавок");
        Article coffeeArticle = new Article("Кофе", "Молотый кофе");
        try {
            Product cucumber = new DiscountedProduct("  ", 200, 20);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        try {
            Product AppleJuice = new DiscountedProduct("Яблочный сок", 129, -50);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

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

        System.out.println("productBasket1.removeProductFromBasket(milk) = " +
                productBasket1.removeProductFromBasket(milk));
        productBasket1.printBasket();

        System.out.println("productBasket1.removeProductFromBasket(milk) = " +
                productBasket1.removeProductFromBasket(milk));
        productBasket1.printBasket();

        SearchEngine first = new SearchEngine();
        first.add(milk);
        first.add(blackTeaArticle);
        first.add(banana);
        first.add(carrot);
        first.add(chicken);
        first.add(blueberry);
        first.add(greenTeaArticle);
        first.add(chocolate);
        first.add(coffeeArticle);
        first.add(milk);
        first.add(milk);

        System.out.println("first = " + first);
        Set<Searchable> searchResults = first.search("ко");
        System.out.println(searchResults);
        System.out.println("first.search(\"ко\") = " + first.search("ко"));
        try {
            System.out.println("first.findMostSimilarProduct(\"я\") = " + first.findMostSimilarProduct("я"));
        } catch (BestResultNotFoundException e) {
            System.out.println("Caught BestResultNotFound");
        }

        try {
            System.out.println("first.findMostSimilarProduct(\"о\") = " + first.findMostSimilarProduct("о"));
        } catch (BestResultNotFoundException e) {
            System.err.println("Caught BestResultNotFound");
        }
    }
}