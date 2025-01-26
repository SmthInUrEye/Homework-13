package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        //Создание продуктов для корзины
        Product apple = new Product ( "Яблоко", 500 );

        Product orange = new Product ( "Апельсин", 100 );

        Product milk = new Product ( "Молоко", 200 );

        Product juice = new Product ( "Сок", 150 );

        Product water = new Product ( "Вода", 50 );

        //Создание первой корзины
        ProductBasket firstBasket = new ProductBasket ();

        //Наполнение корзины товарами
        firstBasket.addProduct ( apple );
        firstBasket.addProduct ( juice );
        firstBasket.addProduct ( milk );
        firstBasket.addProduct ( orange );
        firstBasket.addProduct ( water );

        System.out.println ( "+++Добавление товара сверх лимита корзины+++" );
        firstBasket.addProduct ( apple );

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
