package ma.sdia.infractionservice.web;

import lombok.AllArgsConstructor;
import ma.sdia.infractionservice.entities.Infraction;
import ma.sdia.infractionservice.feignApi.RadarsRestClient;
import ma.sdia.infractionservice.feignApi.VehiclesRestClient;
import ma.sdia.infractionservice.models.NewInfraction;
import ma.sdia.infractionservice.models.Radar;
import ma.sdia.infractionservice.models.Vehicle;
import ma.sdia.infractionservice.repositories.InfractionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
public class RestApi {
    private InfractionRepository infractionRepository;
    private VehiclesRestClient vehiclesRestClient;
    private RadarsRestClient radarsRestClient;


    @GetMapping("/infractions")
    public List<Infraction> getAllInfractions(){
        List<Infraction> infractionList = infractionRepository.findAll();
        infractionList.forEach(infraction -> {
            Vehicle vehicle = vehiclesRestClient.getVehicleById(infraction.getRegistrationNumber());
            Radar radar=radarsRestClient.getRadarById(infraction.getIdRadar());
            infraction.setVehicle(vehicle);
            infraction.setRadar(radar);
        });
        return infractionList;
    }
    @PostMapping("/infractions/add")
    public Infraction addInfraction(@RequestBody NewInfraction newInfraction){
        Vehicle vehicle = vehiclesRestClient.getVehicleById(newInfraction.getRegNbr());
        Radar radar=radarsRestClient.getRadarById(newInfraction.getIdRadar());
        Random random=new Random();
        Infraction infraction=Infraction.builder().vehicleSpeed((int) newInfraction.getVehicleSpeed())
                .date(String.valueOf(new Date())).radar(radar).idRadar(newInfraction.getIdRadar())
                .amount(random.nextInt(1000)).registrationNumber(newInfraction.getRegNbr())
                .vehicle(vehicle).radarMaxSpeed(radar.getMaxSpeed()).build();
        return infractionRepository.save(infraction);
    }
}
