package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private final Product[] products;
    private int size = 0;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProductInBasket(Product product) {
        if (size >= products.length) {
            System.out.println("Корзина переполнена, продукт " + product.getProductDesignation() + " не добавлен");
        } else {
            products[size++] = product;
            System.out.println("Продукт " + product.getProductDesignation() + " добавлен в корзину");
        }
    }

    public int calcTotalBasketCost() {
        int totalCost = 0;
        for (Product value : products) {
            if (value != null) {
                totalCost += value.getPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        for (Product value : products) {
            if (value != null) {
                System.out.println(value.getProductDesignation() + ": " + value.getPrice());
            }
        }
        if (calcTotalBasketCost() == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + calcTotalBasketCost());
        }
    }

    public boolean checkProduct(String productDesignation) {
        for (Product value : products) {
            if (value != null && Objects.equals(value.getProductDesignation(), productDesignation)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
                size--;
            }
        }
    }

    public String toString() {
        return Arrays.toString(this.products);
    }
}
