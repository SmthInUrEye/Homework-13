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
    public int getPrice() {
        return (BaseValue - ((BaseValue * Discount) / 100));
    }

    @Override
    public String toString() {
        return (getProductName () + ": " + getPrice () + "(" + Discount + ")");
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String searchTerm() {
        return getProductName ();
    }

    @Override
    public String checkContentType() {
        return "DISCOUNTED PRODUCT";
    }
}
