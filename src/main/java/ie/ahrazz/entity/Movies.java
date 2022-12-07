package ie.ahrazz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    private Integer movie_Id;
    private String title;
    private Integer yearReleased;
    private float taking;
    private Integer director_id;
}
