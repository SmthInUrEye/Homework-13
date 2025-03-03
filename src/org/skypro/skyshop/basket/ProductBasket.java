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
        int totalBasketValue;
        totalBasketValue = productsInBasket
                .values ()
                .stream ()
                .flatMap ( List::stream )
                .mapToInt ( Product::getPrice )
                .sum ();
        System.out.println ( "Общая стоимость корзины: " + totalBasketValue );
    }

    private int getSpecialCount() {
        int specialCounter;
        specialCounter = (int) productsInBasket.values ().stream ().flatMap ( List::stream ).filter ( Product::isSpecial ).count ();
        return specialCounter;
    }

    public void printBasketInfo() {
        productsInBasket.values ()
                .stream ()
                .flatMap ( List::stream )
                .forEach ( System.out::println );
        printBasketValue ();
        System.out.println ( "Специальных товаров: " + getSpecialCount () );
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





