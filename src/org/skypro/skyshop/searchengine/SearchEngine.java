package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine implements org.skypro.skyshop.interfaces.Searchable {

    public Searchable[] SearchableElements;

    public SearchEngine(int numOfSearchElements) {
        this.SearchableElements = new Searchable[numOfSearchElements];
    }

    private int counter = 0;

    public void add(Searchable target) {
        if ( counter >= SearchableElements.length ) {
            System.out.println ( "Переполнение поисковых элементов" );
        } else {
            SearchableElements[counter] = target;
            counter++;
        }
    }

    public String[] search(String search) {
        String[] result = new String[5];
        for (int i = 0; i < SearchableElements.length; i++) {
            if ( SearchableElements[i].searchTerm ().contains ( search ) ) {
                result[i] = SearchableElements[i].getStringRepresentation ();
            } else result[i] = null;
        }
        return result;
    }

    @Override
    public String searchTerm() {
        return "";
    }

    @Override
    public String checkContentType() {
        return "";
    }


}
