package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine implements org.skypro.skyshop.interfaces.Searchable {

    public Searchable[] searchableElements;

    private int counter = 0;

    public SearchEngine(int numOfSearchElements) {
        this.searchableElements = new Searchable[numOfSearchElements];
    }

    public void add(Searchable target) {
        if (counter >= searchableElements.length) {
            System.out.println("Переполнение поисковых элементов");
        } else {
            searchableElements[counter] = target;
            counter++;
        }
    }

    public String[] search(String search) {
        String[] result = new String[5];
        for (int i = 0; i < searchableElements.length; i++) {
            if (searchableElements[i].searchTerm().contains(search)) {
                result[i] = searchableElements[i].getStringRepresentation();
            } else result[i] = null;
        }
        return result;
    }

    public int maxRepeats(String search, String placeToSearch) {
        int maxRepeats = 0;
        while (search.length() <= placeToSearch.length()) {
            if (placeToSearch.contains(search)) {
                maxRepeats++;
            } else break;
        }
        return maxRepeats;
    }

    //public Searchable findBestResult (String search) {}

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
