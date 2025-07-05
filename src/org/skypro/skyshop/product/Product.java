package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productDesignation;

    public Product(String productDesignation) {
        if ((productDesignation == null) || productDesignation.isBlank()) {
            throw new IllegalArgumentException("Недопустимое название продукта!");
        }
        this.productDesignation = productDesignation;
    }

    public String getProductDesignation() {
        return productDesignation;
    }

    public abstract int getPrice();

    public String toString() {
        return getProductDesignation() + ": " + getPrice();
    }

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return getProductDesignation();
    }

    @Override
    public String typeContent() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productDesignation, product.productDesignation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productDesignation);
    }
}


