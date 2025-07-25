package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchElements;

    public SearchEngine() {
        this.searchElements = new HashSet<>();
    }


    public Set<Searchable> search(String term) {
        return searchElements.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getSearchTerm().contains(term))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public void add(Searchable searchable) {
        searchElements.add(searchable);
    }

    public Set<Searchable> findMostSimilarProduct(String search) throws BestResultNotFoundException {
        Set<Searchable> result = new HashSet<>();
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
                    result.add(searchElement);
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
