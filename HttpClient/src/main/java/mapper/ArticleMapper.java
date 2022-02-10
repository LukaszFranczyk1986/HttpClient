package mapper;

import http.response.Article;
import model.ArticleOutput;

public interface ArticleMapper {

    public ArticleOutput mapResponseToOutput(Article article);
}
