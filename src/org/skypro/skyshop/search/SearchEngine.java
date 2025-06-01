package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchElements;
    int size;

    public SearchEngine(int size) {
        this.searchElements = new Searchable[size];
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int j = 0;
        for (Searchable elem : searchElements) {
            if (elem != null && elem.getSearchTerm().contains(term)) {
                results[j] = elem;
                j++;
            }
            if (j == 5) {
                break;
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchElements.length; i++) {
            if (searchElements[i] == null) {
                searchElements[i] = searchable;
                return;
            }
        }
    }

    public String toString() {
        return Arrays.toString(this.searchElements);
    }
}
