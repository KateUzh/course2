package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private final Product[] products;
    private int size = 0;
    private static int countSpecialProduct;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProductInBasket(Product product) {
        if (size >= products.length) {
            System.out.println("Корзина переполнена, продукт " + product.getProductDesignation() + " не добавлен");
        } else {
            products[size++] = product;
            System.out.println("Продукт " + product.getProductDesignation() + " добавлен в корзину");
            if (product.isSpecial()) {
                countSpecialProduct++;
            }
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
                System.out.println(value);
            }
        }
        if (calcTotalBasketCost() == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + calcTotalBasketCost());
            System.out.println("Специальных товаров: " + countSpecialProduct);
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
        Arrays.fill(products, null);
        size = 0;
        countSpecialProduct = 0;
    }

    public String toString() {
        return Arrays.toString(this.products);
    }
}
