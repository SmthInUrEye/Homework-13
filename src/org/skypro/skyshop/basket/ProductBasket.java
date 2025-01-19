package org.skypro.skyshop.basket;

public class ProductBasket {

    private String[] ProductsInBasketNames;
    private int[] ProductsInBasketValues;
    private int counter = 0;

    public void setProductsInBasketNames() {
        this.ProductsInBasketNames = new String[5];
    }

    public void setProductsInBasketValues() {
        this.ProductsInBasketValues = new int[5];
    }

    public void addProduct(String ProductName, int ProductCost) {
        if ( counter >= ProductsInBasketNames.length ) {
            System.out.println ( "В корзине нет места" );
        } else {
            ProductsInBasketNames[counter] = ProductName;
            ProductsInBasketValues[counter] = ProductCost;
            counter++;
        }
    }

    public void printBasketValue() {
        int TotalBasketValue = 0;
        for (int i = 0; i < ProductsInBasketNames.length; i++) {
            TotalBasketValue += ProductsInBasketValues[i];
        }
        System.out.println ( "Общая стоимость корзины:" + TotalBasketValue );
    }

    public void printBasketInfo() {
        for (int i = 0; i < ProductsInBasketNames.length; i++) {
            System.out.println ( ProductsInBasketNames[i] + ": " + ProductsInBasketValues[i] );
        }
    }

    public boolean checkProduct(String ProductName) {
        boolean flag = false;
        for (int i = 0; i < ProductsInBasketNames.length; i++) {
            if ( ProductName.equals ( ProductsInBasketNames[i] ) ) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void clearBasket() {
        for (int i = 0; i < ProductsInBasketNames.length; i++) {
            ProductsInBasketNames[i] = null;
            ProductsInBasketValues[i] = 0;
        }
    }
}





