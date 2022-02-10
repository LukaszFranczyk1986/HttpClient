package http.response;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(setterPrefix = "with")
public class Article {

    @SerializedName("source")
    private Source source;
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("content")
    private String content;

}