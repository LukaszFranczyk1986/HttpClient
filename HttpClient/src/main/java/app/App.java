package app;

import http.ApiClient;
import http.response.Article;
import http.response.NewsDto;
import io.OpenCsv;
import io.impl.OpenCsvImpl;
import mapper.ArticleMapper;
import mapper.impl.ArticleMapperImpl;
import model.ArticleOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private ArticleMapper articleMapper = new ArticleMapperImpl();
    private OpenCsv openCsv = new OpenCsvImpl();

    public void run() {
        System.out.println("Podaj nazwe pliku do zapisania danych: ");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = rd.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HttpResponse<String> stringHttpResponse = ApiClient.sendRequest("https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=832913d72b6c495ab170fa21eb4abae7");
        NewsDto newsDto = ApiClient.jsonToPojoConvert(stringHttpResponse, NewsDto.class);
        List<Article> articles = newsDto.getArticles();
        List<ArticleOutput> articleOutputs = articles.stream().map(articleMapper::mapResponseToOutput).collect(Collectors.toList());

        openCsv.saveArticleToFile(articleOutputs,fileName);
    }
}
