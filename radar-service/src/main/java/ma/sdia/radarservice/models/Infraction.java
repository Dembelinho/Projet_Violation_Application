package ma.sdia.radarservice.models;

import lombok.*;
import ma.sdia.radarservice.entities.Radar;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class Infraction {
    private Long id;
    private Vehicle vehicule;
    private int vehicleSpeed;
    private int radarMaxSpeed;
    private double amount;
    private  String date;
    private long idRadar;
    private String registrationNumber;
    private Radar radar;
}
