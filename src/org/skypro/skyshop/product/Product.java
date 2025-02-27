package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Product implements Searchable {

    protected final String productName;

    public Product(String productName) {
        checkProductName ( productName );
        this.productName = productName;
    }

    public static void checkProductName(String productName) {
        if ( productName.isBlank () ) throw new IllegalArgumentException ( "Пустое наименование товара" );
    }

    public abstract String getProductName();

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String toString() {
        return "ProductName" + '{' + productName + '}';
    }

    @Override
    public String checkContentType() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
        return getProductName ();
    }

    @Override
    public String getSearchableName() {
        return "ProductName" + '{' + getProductName () + '}';
    }

}



