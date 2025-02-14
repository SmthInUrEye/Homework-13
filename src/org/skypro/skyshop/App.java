package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.io.IOException;


public class App {

    public static void main(String[] args) {

        //Создание продуктов для корзины
        SimpleProduct apple = new SimpleProduct("Яблоко", 500);

        SimpleProduct orange = new SimpleProduct("Апельсин", 100);

        SimpleProduct milk = new SimpleProduct("Молоко", 200);

        Product juice = new SimpleProduct("Сок", 150);

        Product water = new SimpleProduct("Вода", 50);

        Product banana = new FixPriceProduct("Банан");

        Product wine = new DiscountedProduct("Вино", 450, 25);

        //Создание первой корзины
        ProductBasket firstBasket = new ProductBasket();

        //Наполнение корзины товарами
        firstBasket.addProduct(apple);
        firstBasket.addProduct(juice);
        firstBasket.addProduct(milk);
        firstBasket.addProduct(banana);
        firstBasket.addProduct(wine);

        //Создание статей для поиска
        Article articleAboutBanana = new Article("Статья про бананы",
                "Бананы очень полезны для организма. Растут на деревьях");

        Article articleAboutApple = new Article("Статья про яблоки",
                "Яблок всегда мало и они часто используются в школьных задачках");

        //Создание поискового объекта
        SearchEngine searchableArray = new SearchEngine(5);
        searchableArray.add(banana);
        searchableArray.add(apple);
        searchableArray.add(apple);
        searchableArray.add(articleAboutApple);
        searchableArray.add(articleAboutBanana);

        //Объявление массива результатов поиска
        String[] result;

        //Создание некорректных объектов классов

        try {
            Product brokenApple = new FixPriceProduct("  ");
            SimpleProduct brokenOrange = new SimpleProduct("Сломанный Апельсин", -40);
            DiscountedProduct brokenJuice = new DiscountedProduct("Сломанный сок", 40, 150);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
