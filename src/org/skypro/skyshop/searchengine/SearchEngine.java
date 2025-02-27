package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exeptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine implements org.skypro.skyshop.interfaces.Searchable {

    public LinkedList<Searchable> searchableElements = new LinkedList<> ();

    public void add(Searchable target) {
        searchableElements.add ( target );
    }

    public Map<String, Searchable> search(String search) {

        Map<String, Searchable> result = new TreeMap<> ();

        for (Searchable searchableElement : searchableElements) {
            if ( searchableElement.searchTerm ().contains ( search ) ) {
                result.put ( searchableElement.getSearchableName (), searchableElement );
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
