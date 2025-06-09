package org.skypro.skyshop.search;

public class BestResultNotFoundException extends Exception {
    public BestResultNotFoundException(String search) {
        System.out.println("Для поискового запроса \"" + search + "\" не нашлось подходящего товара");
    }
}