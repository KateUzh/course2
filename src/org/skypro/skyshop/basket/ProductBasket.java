package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final LinkedList<Product> products;
    private int size = 0;
    private static int countSpecialProduct;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProductInBasket(Product product) {
        products.add(product);
        size++;
        System.out.println("Продукт " + product.getProductDesignation() + " добавлен в корзину");
        if (product.isSpecial()) {
            countSpecialProduct++;
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
        products.clear();
        size = 0;
        countSpecialProduct = 0;
    }

    public List<Product> removeProductFromBasket(Product productDesignation) {
        Iterator<Product> iterator = products.iterator();
        List<Product> removeProductList = new LinkedList<>();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element != null & productDesignation.equals(element)) {
                iterator.remove();
                removeProductList.add(element);
            }
        }
        if (removeProductList.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeProductList;
    }


    @Override
    public String toString() {
        return "ProductBasket{" +
                "products=" + products +
                '}';
    }
}
