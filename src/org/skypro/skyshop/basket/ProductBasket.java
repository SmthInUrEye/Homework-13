package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private int SpecialCounter = 0;
    private final Product[] ProductsInBasket = new Product[5];
    private int counter = 0;

    public void addProduct(Product ProductName) {
        if ( counter >= ProductsInBasket.length ) {
            System.out.println ( "В корзине нет места" );
        } else {
            ProductsInBasket[counter] = ProductName;
            counter++;
        }
    }

    public void printBasketValue() {
        int TotalBasketValue = 0;
        for (int i = 0; i < ProductsInBasket.length; i++) {
            if ( ProductsInBasket[i] != null ) {
                {
                    TotalBasketValue += ProductsInBasket[i].getPrice ();
                }
            } else {
                TotalBasketValue += 0;
            }
        }
        System.out.println ( "Общая стоимость корзины: " + TotalBasketValue );
    }

    public void printBasketInfo() {
        for (int i = 0; i < ProductsInBasket.length; i++) {
            System.out.println ( ProductsInBasket[i] );
            if ( ProductsInBasket[i] != null && ProductsInBasket[i].isSpecial () ) {
                SpecialCounter++;
            }
        }
        printBasketValue ();
        System.out.println ( "Специальных товаров: " + SpecialCounter );

    }

    public boolean checkProduct(String ProductName) {
        boolean flag = false;
        for (int i = 0; i < ProductsInBasket.length; i++) {
            if ( ProductsInBasket[i] != null ) {
                if ( ProductName.equals ( ProductsInBasket[i].getProductName () ) ) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public void clearBasket() {
        for (int i = 0; i < ProductsInBasket.length; i++) {
            ProductsInBasket[i] = null;
            SpecialCounter = 0;
        }
    }
}





