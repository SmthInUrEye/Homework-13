package org.skypro.skyshop.interfaces;

public interface Searchable {

    String searchTerm();

    String checkContentType();

    String getSearchableName();

    default String getStringRepresentation() {
        return (getSearchableName () + " - " + checkContentType ());
    }

}
