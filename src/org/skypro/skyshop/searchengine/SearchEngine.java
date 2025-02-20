package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exeptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.LinkedList;

public class SearchEngine implements org.skypro.skyshop.interfaces.Searchable {

    public LinkedList<Searchable> searchableElements = new LinkedList<> ();

    public void add(Searchable target) {
        searchableElements.add ( target );
    }

    public LinkedList<String> search(String search) {

        LinkedList<String> result = new LinkedList<> ();

        for (Searchable searchableElement : searchableElements) {
            if ( searchableElement.searchTerm ().contains ( search ) ) {
                result.add ( searchableElement.getStringRepresentation () );
            }
        }
        return result;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {

        int bestResultIndex = -1;
        int maxRepeatsInSearch = 0;

        for (int i = 0; i < searchableElements.size (); i++) {
            if ( maxRepeatsInSearch < getSearchTerm ( search, searchableElements.get ( i ).searchTerm () ) ) {
                maxRepeatsInSearch = getSearchTerm ( search, searchableElements.get ( i ).searchTerm () );
                bestResultIndex = i;
            }
        }

        if ( maxRepeatsInSearch == 0 ) {
            throw new BestResultNotFound ( search );
        }
        return searchableElements.get ( bestResultIndex );
    }

    @Override
    public String searchTerm() {
        return "";
    }

    @Override
    public String checkContentType() {
        return "";
    }

    @Override
    public String getSearchableName() {
        return "";
    }

}
