package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private int specialCounter = 0;
    private final Product[] productsInBasket = new Product[5];
    private int counter = 0;

    public void addProduct(Product productName) {
        if (counter >= productsInBasket.length) {
            System.out.println("В корзине нет места");
        } else {
            productsInBasket[counter] = productName;
            counter++;
        }
    }

    public void printBasketValue() {
        int totalBasketValue = 0;
        for (int i = 0; i < productsInBasket.length; i++) {
            if (productsInBasket[i] != null) {
                {
                    totalBasketValue += productsInBasket[i].getPrice();
                }
            } else {
                totalBasketValue += 0;
            }
        }
        System.out.println("Общая стоимость корзины: " + totalBasketValue);
    }

    public void printBasketInfo() {
        for (int i = 0; i < productsInBasket.length; i++) {
            System.out.println(productsInBasket[i]);
            if (productsInBasket[i] != null && productsInBasket[i].isSpecial()) {
                specialCounter++;
            }
        }
        printBasketValue();
        System.out.println("Специальных товаров: " + specialCounter);

    }

    public boolean checkProduct(String ProductName) {
        boolean flag = false;
        for (int i = 0; i < productsInBasket.length; i++) {
            if (productsInBasket[i] != null) {
                if (ProductName.equals(productsInBasket[i].getProductName())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public void clearBasket() {
        for (int i = 0; i < productsInBasket.length; i++) {
            productsInBasket[i] = null;
            specialCounter = 0;
        }
    }
}





