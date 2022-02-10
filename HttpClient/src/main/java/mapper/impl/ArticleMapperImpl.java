package mapper.impl;

import http.response.Article;
import mapper.ArticleMapper;
import model.ArticleOutput;

public class ArticleMapperImpl implements ArticleMapper {
    @Override
    public ArticleOutput mapResponseToOutput(Article article) {
        return ArticleOutput.builder()
                .withTitle(article.getTitle())
                .withDescription(article.getDescription())
                .withAuthor(article.getAuthor())
                .build();
    }
}
