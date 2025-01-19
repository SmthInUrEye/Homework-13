package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.product;

public class App {
    public static void main(String[] args) {

        //Создание продуктов для корзины
        product apple = new product ();
        apple.setProductName ( "Яблоко" );
        apple.setProductValue ( 500 );

        product orange = new product ();
        orange.setProductName ( "Апельсин" );
        orange.setProductValue ( 100 );

        product milk = new product ();
        milk.setProductName ( "Молоко" );
        milk.setProductValue ( 200 );

        product juice = new product ();
        juice.setProductName ( "Сок" );
        juice.setProductValue ( 150 );

        product water = new product ();
        water.setProductName ( "Вода" );
        water.setProductValue ( 50 );

        //Создание первой корзины
        ProductBasket firstBasket = new ProductBasket ();
        firstBasket.setProductsInBasketNames ();
        firstBasket.setProductsInBasketValues ();

        //Наполнение корзины товарами
        firstBasket.addProduct ( apple.getProductName (), apple.getProductValue () );
        firstBasket.addProduct ( juice.getProductName (), juice.getProductValue () );
        firstBasket.addProduct ( milk.getProductName (), milk.getProductValue () );
        firstBasket.addProduct ( orange.getProductName (), orange.getProductValue () );
        firstBasket.addProduct ( water.getProductName (), water.getProductValue () );

        System.out.println ( "+++Добавление товара сверх лимита корзины+++" );
        firstBasket.addProduct ( apple.getProductName (), apple.getProductValue () );

        System.out.println ( "+++Печать всей корзины+++" );
        firstBasket.printBasketInfo ();

        System.out.println ( "+++Печать общей стоимости корзины+++" );
        firstBasket.printBasketValue ();

        System.out.println ( "+++Проверка отсутствующего товара+++" );
        if ( firstBasket.checkProduct ( "Мясо" ) )
            System.out.println ( "Товар есть в корзине" );
        else System.out.println ( "Товар не найден" );

        System.out.println ( "+++Проверка существующего товара+++" );
        if ( firstBasket.checkProduct ( "Яблоко" ) )
            System.out.println ( "Товар есть в корзине" );
        else System.out.println ( "Товар не найден" );

        System.out.println ( "+++Проверка пустой корзины+++" );
        firstBasket.clearBasket ();
        firstBasket.printBasketInfo ();
        firstBasket.printBasketValue ();
        if ( firstBasket.checkProduct ( "Яблоко" ) )
            System.out.println ( "Товар есть в корзине" );
        else System.out.println ( "Товар не найден" );

    }
}
