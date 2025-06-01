package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String typeContent();

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + typeContent();
    }

}
