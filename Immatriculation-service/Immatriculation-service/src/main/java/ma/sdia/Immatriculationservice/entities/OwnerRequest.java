package ma.sdia.Immatriculationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// for GraphQL
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRequest {
    private String name;
    private String birthDay;
    private String email;

}
