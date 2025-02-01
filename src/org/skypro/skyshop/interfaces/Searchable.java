package org.skypro.skyshop.interfaces;

public interface Searchable {

    String searchTerm();

    String checkContentType();

    default String getStringRepresentation() {
        return (searchTerm () + " - " + checkContentType ());
    }

}
