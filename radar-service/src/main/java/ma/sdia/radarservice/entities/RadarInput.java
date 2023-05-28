package ma.sdia.radarservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RadarInput {
    private int MaxSpeed;
    private double Longitude , Latitude;
}
