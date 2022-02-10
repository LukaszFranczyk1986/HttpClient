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
public class Source {

    @SerializedName("id")
    private Object id;
    @SerializedName("name")
    private String name;
}