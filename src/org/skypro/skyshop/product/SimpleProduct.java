package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int productValue;

    public SimpleProduct(String productName, int productValue) {
        super(productName);
        checkSimpleProductPrice(productValue);
        this.productValue = productValue;
    }

    public static void checkSimpleProductPrice(int productValue) {
        if (productValue < 0) throw new IllegalArgumentException("Цена должна быть больше 0");
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
        return (getProductName() + ": " + getPrice());
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

}
