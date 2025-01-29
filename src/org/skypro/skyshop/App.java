package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        //Создание продуктов для корзины
        SimpleProduct apple = new SimpleProduct ( "Яблоко", 500 );

        SimpleProduct orange = new SimpleProduct ( "Апельсин", 100 );

        SimpleProduct milk = new SimpleProduct ( "Молоко", 200 );

        Product juice = new SimpleProduct ( "Сок", 150 );

        Product water = new SimpleProduct ( "Вода", 50 );

        Product banana = new FixPriceProduct ( "Банан" );

        Product wine = new DiscountedProduct ( "Вино", 540, 25 );

        //Создание первой корзины
        ProductBasket firstBasket = new ProductBasket ();

        //Наполнение корзины товарами
        firstBasket.addProduct ( apple );
        firstBasket.addProduct ( juice );
        firstBasket.addProduct ( milk );
        firstBasket.addProduct ( banana );
        firstBasket.addProduct ( wine );

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
