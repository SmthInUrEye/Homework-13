package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.io.IOException;
import java.util.LinkedList;


public class App {

    public static void main(String[] args) {

        //Создание продуктов для корзины
        SimpleProduct apple = new SimpleProduct ( "Яблоко", 500 );

        SimpleProduct orange = new SimpleProduct ( "Апельсин", 100 );

        SimpleProduct milk = new SimpleProduct ( "Молоко", 200 );

        Product juice = new SimpleProduct ( "Сок", 150 );

        Product water = new SimpleProduct ( "Вода", 50 );

        Product banana = new FixPriceProduct ( "Банан" );

        Product wine = new DiscountedProduct ( "Вино", 450, 25 );

        //Создание первой корзины
        ProductBasket firstBasket = new ProductBasket ();

        //Создание корзины удалённых товаров
        LinkedList<Product> deletedProducts = new LinkedList<> ();

        //Наполнение корзины товарами
        firstBasket.addProduct ( apple );
        firstBasket.addProduct ( juice );
        firstBasket.addProduct ( milk );
        firstBasket.addProduct ( banana );
        firstBasket.addProduct ( wine );
        firstBasket.addProduct ( banana );
        firstBasket.addProduct ( milk );

        //Создание статей для поиска
        Article articleAboutBanana = new Article ( "Статья про бананы",
                "Бананы очень полезны для организма. Растут на деревьях" );

        Article articleAboutApple = new Article ( "Статья про яблоки",
                "Яблок всегда мало и они часто используются в школьных задачках" );

        //Создание поискового объекта
        SearchEngine searchableArray = new SearchEngine ();
        searchableArray.add ( banana );
        searchableArray.add ( apple );
        searchableArray.add ( apple );
        searchableArray.add ( articleAboutApple );
        searchableArray.add ( articleAboutBanana );

        //Создание некорректных объектов классов
        System.out.println ( "\nТестирование продуктовых исключений" );
        try {
            Product brokenApple = new FixPriceProduct ( "  " );
            SimpleProduct brokenOrange = new SimpleProduct ( "Сломанный Апельсин", -40 );
            DiscountedProduct brokenJuice = new DiscountedProduct ( "Сломанный сок", 40, 150 );
        } catch (Exception e) {
            System.out.println ( e );
        }

        //Демонстрация поиска наиболее подходящего результата
        Searchable bestResult;
        Searchable brokenBestResult;
        try {
            System.out.println ( "\nИщем существующий объект" );
            bestResult = searchableArray.findBestResult ( "банан" );
            System.out.println ( bestResult.getStringRepresentation () );

            System.out.println ( "\nИщем несуществующий объект" );
            brokenBestResult = searchableArray.findBestResult ( "Космос" );
            System.out.println ( brokenBestResult.getStringRepresentation () );
        } catch (Exception e) {
            System.out.println ( e );
        }

        System.out.println ( "\nТестирование после перехода на списки" );
        firstBasket.printBasketInfo ();

        System.out.println ( "Тестирование удаления продукта из корзины" );

        System.out.println ( "Список удалённых продуктов: " + firstBasket.deleteProduct ( "Банан" ) );

        System.out.println ( "+++Очистка корзины+++" );
        firstBasket.clearBasket ();

        System.out.println ( "+++Вывод новой информации+++" );
        firstBasket.printBasketInfo ();

        System.out.println ( "Пытаемся удалить несущетсвующий продукт:" );
        deletedProducts = firstBasket.deleteProduct ( "Дерево" );

        if ( deletedProducts.isEmpty () ) {
            System.out.println ( "Список пуст" );
        }

    }
}
