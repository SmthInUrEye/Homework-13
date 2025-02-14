package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int productValue;

    public SimpleProduct(String productName, int productValue) {
        super ( productName );
        this.productValue = productValue;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getPrice() {
        return productValue;
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
