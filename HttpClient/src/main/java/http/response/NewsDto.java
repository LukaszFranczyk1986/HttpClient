package http.response;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(setterPrefix = "with")
public class NewsDto {

    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private Integer totalResults;
    @SerializedName("articles")
    private List<Article> articles;

}