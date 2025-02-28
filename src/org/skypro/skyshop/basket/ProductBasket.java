package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> productsInBasket = new HashMap<> ();

    public void addProduct(Product productName) {
        List<Product> existingProducts = productsInBasket.getOrDefault ( productName.getProductName (), new LinkedList<> () );
        existingProducts.add ( productName );
        productsInBasket.put ( productName.getProductName (), existingProducts );
    }

    public void printBasketValue() {
        int totalBasketValue = 0;
        for (List<Product> productsList : productsInBasket.values ()) {
            for (Product product : productsList) {
                if ( product != null ) {
                    {
                        totalBasketValue += product.getPrice ();
                    }
                } else {
                    totalBasketValue += 0;
                }
            }
        }
        System.out.println ( "Общая стоимость корзины: " + totalBasketValue );
    }

    public void printBasketInfo() {
        int specialCounter = 0;
        for (List<Product> productList : productsInBasket.values ()) {
            for (Product product : productList) {
                System.out.println ( product );
                if ( product != null && product.isSpecial () ) {
                    specialCounter++;
                }
            }
        }
        printBasketValue ();
        System.out.println ( "Специальных товаров: " + specialCounter );
    }

    public boolean checkProduct(String ProductName) {
        return (productsInBasket.containsKey ( ProductName ));
    }

    public void clearBasket() {
        this.productsInBasket.clear ();
    }

    public List<Product> deleteProduct(String name) {
        return productsInBasket.remove ( name );
    }
}





