package io;

import http.response.Article;
import model.ArticleOutput;

import java.util.List;

public interface OpenCsv {
    boolean saveArticleToFile(List<ArticleOutput> articles, String fileName);
}
