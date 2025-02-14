package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public abstract class Product implements Searchable {

    protected final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public abstract String getProductName();

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String toString() {
        return productName;
    }

    @Override
    public String checkContentType() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
        return getProductName();
    }

    @Override
    public String getSearchableName() {
        return getProductName();
    }
}



