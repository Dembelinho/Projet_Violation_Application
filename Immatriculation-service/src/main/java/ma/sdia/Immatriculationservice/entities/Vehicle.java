package ma.sdia.Immatriculationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Vehicle {
    @Id
    private String registrationNumber;
    private String brand;
    private int model;
    private double fiscalPower;
    @ManyToOne
    private Owner owner;
}