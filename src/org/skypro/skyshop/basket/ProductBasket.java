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
        boolean flag = false;
        for (List<Product> productList : productsInBasket.values ()) {
            for (Product product : productList) {
                if ( product != null ) {
                    if ( ProductName.equals ( product.getProductName () ) ) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public void clearBasket() {
        Iterator<Map.Entry<String, List<Product>>> productIterator = productsInBasket.entrySet ().iterator ();
        while (productIterator.hasNext ()) {
            productIterator.next ();
            productIterator.remove ();
        }
    }

    public LinkedList<Product> deleteProduct(String name) {

        Iterator<Map.Entry<String, List<Product>>> productIterator = productsInBasket.entrySet ().iterator ();
        LinkedList<Product> deletedProducts = new LinkedList<> ();

        while (productIterator.hasNext ()) {
            Map.Entry<String, List<Product>> entry = productIterator.next ();
            List<Product> productList = entry.getValue ();
            Iterator<Product> productListIterator = productList.iterator ();
            while (productListIterator.hasNext ()) {
                Product product = productListIterator.next ();
                if ( product.getProductName ().equals ( name ) ) {
                    deletedProducts.add ( product );
                    productListIterator.remove ();
                }
            }
            if ( productList.isEmpty () ) {
                productIterator.remove ();
            }
        }
        return deletedProducts;
    }
}





