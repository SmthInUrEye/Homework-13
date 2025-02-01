package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public abstract class Product implements Searchable {

    protected final String ProductName;

    public Product(String ProductName) {
        this.ProductName = ProductName;
    }

    public abstract String getProductName();

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String toString() {
        return ProductName;
    }

}
