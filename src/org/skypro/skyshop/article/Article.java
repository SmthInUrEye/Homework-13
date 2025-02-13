package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

public class Article implements Searchable {

    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "Article{" +
                "ArticleName='" + articleName + '\'' +
                ", ArticleText='" + articleText + '\'' +
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
        return articleName;
    }
}
