package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int baseValue;
    private final int discount;

    public DiscountedProduct(String productName, int baseValue, int discount) {
        super(productName);
        this.baseValue = baseValue;
        this.discount = discount;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getPrice() {
        return (baseValue - ((baseValue * discount) / 100));
    }

    @Override
    public String toString() {
        return (getProductName() + ": " + getPrice() + "(" + discount + ")");
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}


