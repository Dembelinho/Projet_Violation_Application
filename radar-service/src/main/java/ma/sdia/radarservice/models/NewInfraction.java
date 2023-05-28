package ma.sdia.radarservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class NewInfraction {
    long idRadar;
    String registrationNumber;
    int vehicleSpeed;
}
