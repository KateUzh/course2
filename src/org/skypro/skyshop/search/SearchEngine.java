package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final Map<String, Searchable> searchElements;

    public SearchEngine() {
        this.searchElements = new TreeMap<>();
    }

    public Map<String, Searchable> search(String term) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable elem : searchElements.values()) {
            if (elem != null && elem.getSearchTerm().contains(term)) {
                results.put(elem.getStringRepresentation(), elem);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchElements.put(searchable.getSearchTerm(), searchable);
    }

    public Map<String, Searchable> findMostSimilarProduct(String search) throws BestResultNotFoundException {
        Map<String, Searchable> result = new TreeMap<>();
        int maxCount = 0;
        for (Searchable searchElement : searchElements.values()) {
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
                    result.put(searchElement.getStringRepresentation(), searchElement);
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
        return "SearchEngine{" +
                "searchElements=" + searchElements +
                '}';
    }
}
