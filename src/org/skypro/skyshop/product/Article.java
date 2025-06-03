package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String titleOfArticle;
    private final String textOfArticle;

    public Article(String titleOfArticle, String textOfArticle) {
        this.titleOfArticle = titleOfArticle;
        this.textOfArticle = textOfArticle;
    }

    public String toString() {
        return this.titleOfArticle + ", " + this.textOfArticle;
    }
    @Override
    public String getSearchTerm() {
        return toString();
    }
    @Override
    public String typeContent() {
        return "ARTICLE";
    }
}
