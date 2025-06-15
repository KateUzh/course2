package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final LinkedList<Searchable> searchElements;

    public SearchEngine() {
        this.searchElements = new LinkedList<>();
    }

    public List<Searchable> search(String term) {
        ArrayList<Searchable> results = new ArrayList<>();
        for (Searchable elem : searchElements) {
            if (elem != null && elem.getSearchTerm().contains(term)) {
                results.add(elem);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchElements.add(searchable);
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
        return "SearchEngine{" +
                "searchElements=" + searchElements +
                '}';
    }
}
