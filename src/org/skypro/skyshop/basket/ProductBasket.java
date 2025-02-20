package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ProductBasket {

    private int specialCounter = 0;
    private final LinkedList<Product> productsInBasket = new LinkedList<>();
    private int counter = 0;


    public void addProduct(Product productName) {
        productsInBasket.add(productName);
        counter++;
    }

    public void printBasketValue() {
        int totalBasketValue = 0;
        for (Product product : productsInBasket) {
            if (product != null) {
                {
                    totalBasketValue += product.getPrice();
                }
            } else {
                totalBasketValue += 0;
            }
        }
        System.out.println("Общая стоимость корзины: " + totalBasketValue);
    }

    public void printBasketInfo() {
        specialCounter = 0;
        for (Product product : productsInBasket) {
            System.out.println(product);
            if (product != null && product.isSpecial()) {
                specialCounter++;
            }
        }
        printBasketValue();
        System.out.println("Специальных товаров: " + specialCounter);
    }

    public boolean checkProduct(String ProductName) {
        boolean flag = false;
        for (Product product : productsInBasket) {
            if (product != null) {
                if (ProductName.equals(product.getProductName())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public void clearBasket() {
        ListIterator<Product> productIterator = productsInBasket.listIterator();
        while (productIterator.hasNext()) {
            productIterator.next();
            productIterator.remove();
        }
    }

    public LinkedList<Product> deleteProduct (String name) {

        ListIterator<Product> productIterator = productsInBasket.listIterator();
        LinkedList <Product> deletedProducts = new LinkedList<>();

        while (productIterator.hasNext()) {
            Product nextProduct = productIterator.next();
            if (nextProduct.getProductName().equals(name)) {
                deletedProducts.add(nextProduct);
                productIterator.remove();
            }
        }
        return deletedProducts;
    }
}





