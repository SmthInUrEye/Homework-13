package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

import java.util.Objects;
import java.util.Comparator;

public class Article implements Searchable {

    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return
                "ArticleText{" + articleText + '}';
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
        return "AricleName{" + articleName + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode ( articleName );
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( obj == null || getClass () != obj.getClass () ) return false;
        Article article = (Article) obj;
        return Objects.equals ( articleName, article.articleName );
    }

}



