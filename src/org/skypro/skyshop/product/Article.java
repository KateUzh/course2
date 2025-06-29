package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleOfArticle, article.titleOfArticle) &&
                Objects.equals(textOfArticle, article.textOfArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfArticle, textOfArticle);
    }
}
