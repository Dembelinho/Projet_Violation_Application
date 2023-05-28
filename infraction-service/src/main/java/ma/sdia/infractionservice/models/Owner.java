package ma.sdia.infractionservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @AllArgsConstructor @Builder @NoArgsConstructor
public class Owner {
    private Long id;
    private String email;
    private String birthDay;
    private String name;
}
