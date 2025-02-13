package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_VALUE = 75;

    public FixPriceProduct(String productName) {
        super ( productName );
    }

    @Override
    public int getPrice() {
        return FIXED_VALUE;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return (getProductName () + ": Фиксированная цена " + getPrice ());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
