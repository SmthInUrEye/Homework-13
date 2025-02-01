package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

public class Article implements Searchable {

    public String ArticleName;
    public String ArticleText;

    public Article(String ArticleName, String ArticleText) {
        this.ArticleName = ArticleName;
        this.ArticleText = ArticleText;
    }

    @Override
    public String toString() {
        return "Article{" +
                "ArticleName='" + ArticleName + '\'' +
                ", ArticleText='" + ArticleText + '\'' +
                '}';
    }

    @Override
    public String searchTerm() {
        return toString ();
    }

    @Override
    public String checkContentType() {
        return "ARTICLE";
    }

}
