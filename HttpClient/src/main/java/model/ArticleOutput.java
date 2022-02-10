package model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(setterPrefix = "with")
public class ArticleOutput {

    @CsvBindByPosition(position = 0)
    private String title;
    @CsvBindByPosition(position = 1)
    private String description;
    @CsvBindByPosition(position = 2)
    private String author;
}
