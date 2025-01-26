package org.skypro.skyshop.product;

public class Product {
    private final String ProductName;

    private final int ProductValue;

    public Product(String ProductName, int ProductValue) {
        this.ProductName = ProductName;
        this.ProductValue = ProductValue;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getProductValue() {
        return ProductValue;
    }

    public String toString() {
        return ProductName + ": " + ProductValue;
    }

}
