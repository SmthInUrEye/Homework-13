package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exeptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.NameComparator;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.*;

public class SearchEngine extends NameComparator implements Searchable {

    public Set<Searchable> searchableElements = new HashSet<> ();

    public void add(Searchable target) {
        searchableElements.add ( target );
    }

    public Set <Searchable> search(String search)  {

        Set<Searchable> result = new TreeSet<> ( new NameComparator ());

        for (Searchable searchableElement : searchableElements) {
            if ( searchableElement.searchTerm ().contains ( search ) ) {
                result.add (  searchableElement );
            }
        }
        return result;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {

        Searchable bestResult = null;
        int maxRepeatsInSearch = 0;

        for (Searchable searchableElement : searchableElements) {
            if ( maxRepeatsInSearch < getSearchTerm ( search, searchableElement.searchTerm () ) ) {
                maxRepeatsInSearch = getSearchTerm ( search, searchableElement.searchTerm () );
                bestResult = searchableElement;
            }
        }
        if ( maxRepeatsInSearch == 0 ) {
            throw new BestResultNotFound ( search );
        }
        return bestResult;
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
