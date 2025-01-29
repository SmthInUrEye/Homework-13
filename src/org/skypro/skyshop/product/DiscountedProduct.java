package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int BaseValue;
    private final int Discount;

    public DiscountedProduct(String ProductName, int BaseValue, int Discount) {
        super ( ProductName );
        this.BaseValue = BaseValue;
        this.Discount = Discount;
    }

    @Override
    public String getProductName() {
        return ProductName;
    }

    @Override
    public int getProductValue() {
        return (BaseValue - ((BaseValue * Discount) / 100));
    }

    @Override
    public String toString() {
        return (getProductName () + ": " + getProductValue () + "(" + Discount + ")");
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
