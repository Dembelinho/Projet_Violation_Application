package ma.sdia.Immatriculationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Owner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String birthDay;
    private String email;
    @OneToMany(mappedBy ="owner")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Vehicle> vehicles;
}
