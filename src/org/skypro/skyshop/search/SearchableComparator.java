package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (o1.getSearchTerm().length() == o2.getSearchTerm().length()) {
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        } else {
            return Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length());
        }
    }
}
