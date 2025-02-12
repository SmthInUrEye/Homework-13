package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

public class Article implements Searchable {

    private final String ArticleName;
    private final String ArticleText;

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

    @Override
    public String getSearchableName() {
        return ArticleName;
    }
}
