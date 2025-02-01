package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int ProductValue;

    public SimpleProduct(String ProductName, int ProductValue) {
        super ( ProductName );
        this.ProductValue = ProductValue;
    }

    @Override
    public String getProductName() {
        return ProductName;
    }

    @Override
    public int getPrice() {
        return ProductValue;
    }

    @Override
    public String toString() {
        return (getProductName () + ": " + getPrice ());
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
