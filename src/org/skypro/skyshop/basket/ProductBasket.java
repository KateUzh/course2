package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;
    private int size = 0;
    private static int countSpecialProduct;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProductInBasket(Product product) {
        products.computeIfAbsent(product.getProductDesignation(), k -> new LinkedList<>()).add(product);
        size++;
        System.out.println("Продукт " + product.getProductDesignation() + " добавлен в корзину");
        if (product.isSpecial()) {
            countSpecialProduct++;
        }

    }

    public int calcTotalBasketCost() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (calcTotalBasketCost() == 0) {
            System.out.println("В корзине пусто");
        } else {
            products.values().stream()
                    .flatMap(List::stream)
                    .forEach(System.out::println);
            System.out.println("Итого: " + calcTotalBasketCost());
            System.out.println("Специальных товаров: " + getSpecialCount());
        }
    }

    private int getSpecialCount() {
        return (int) products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean checkProduct(String productDesignation) {
        for (List<Product> value : products.values()) {
            for (Product product : value) {
                if (product != null && Objects.equals(product.getProductDesignation(), productDesignation)) {
                    return true;
                }
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
        Iterator<List<Product>> iterator = products.values().iterator();
        List<Product> removeProductList = new LinkedList<>();
        while (iterator.hasNext()) {
            List<Product> iteratorProductList = iterator.next();
            for (Product element : iteratorProductList) {
                if (productDesignation.equals(element)) {
                    iterator.remove();
                    removeProductList.add(element);
                }
            }
        }
        if (removeProductList.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removeProductList;
    }


    public String toString() {
        return "ProductBasket{" +
                "products=" + products +
                '}';
    }
}
