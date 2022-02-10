package io.impl;


import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import http.response.Article;
import io.OpenCsv;
import model.ArticleOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class OpenCsvImpl implements OpenCsv {
    private final String path  = System.getProperty("user.dir");


    @Override
    public boolean saveArticleToFile(List<ArticleOutput> articles, String fileName) {
        Writer writer  = null;
        try {
            writer = new FileWriter(path +  "/" +  fileName);
            StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(':')
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            sbc.write(articles);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e){
            System.out.println("Problem podczas zapisywania danych!");
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Problem podczas zapisu pliku !");
            }
        }
        return true;
    }
}
