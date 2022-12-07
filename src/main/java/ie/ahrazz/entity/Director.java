package ie.ahrazz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    private Integer director_id;
    private String firstName;
    private String lastName;
    private Boolean stillActive;
}
