package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchElements;

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

    public Searchable findMostSimilarProduct(String search) throws BestResultNotFoundException {
        Searchable result = null;
        int maxCount = 0;
        for (Searchable searchElement : searchElements) {
            if (searchElement != null) {
                int count = 0;
                int index = 0;
                int elemIndex = searchElement.getSearchTerm().indexOf(search, index);
                while (elemIndex != -1) {
                    count++;
                    index = elemIndex + search.length();
                    elemIndex = searchElement.getSearchTerm().indexOf(search, index);
                }
                if (count > maxCount) {
                    maxCount = count;
                    result = searchElement;
                }
            }
        }
        if (result == null) {
            throw new BestResultNotFoundException(search);
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.searchElements);
    }
}
