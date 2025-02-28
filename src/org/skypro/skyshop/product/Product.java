package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hashCode ( productName );
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( obj == null || getClass () != obj.getClass () ) return false;
        Product product = (Product) obj;
        return Objects.equals ( productName, product.productName );
    }

}



