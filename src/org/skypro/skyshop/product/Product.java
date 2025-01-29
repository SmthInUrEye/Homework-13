package org.skypro.skyshop.product;

public abstract class Product {

    protected final String ProductName;

    public Product(String ProductName) {
        this.ProductName = ProductName;
    }

    public abstract String getProductName();

    public abstract int getProductValue();

    public abstract boolean isSpecial();

    public String toString() {
        return ProductName;
    }

}
