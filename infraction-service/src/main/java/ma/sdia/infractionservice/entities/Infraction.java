package ma.sdia.infractionservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.sdia.infractionservice.models.Radar;
import ma.sdia.infractionservice.models.Vehicle;

@Entity @Data
@AllArgsConstructor @Builder @ToString @NoArgsConstructor
public class Infraction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private long idRadar;
    private String registrationNumber;
    @Transient
    private Radar radar;
    @Transient
    private Vehicle vehicle;

    private int vehicleSpeed;
    private int radarMaxSpeed;
    private double amount;

}
