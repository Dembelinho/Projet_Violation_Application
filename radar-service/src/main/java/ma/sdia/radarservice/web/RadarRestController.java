package ma.sdia.radarservice.web;

import lombok.AllArgsConstructor;
import ma.sdia.radarservice.entities.Radar;
import ma.sdia.radarservice.feign.InfractionRestClient;
import ma.sdia.radarservice.models.NewInfraction;
import ma.sdia.radarservice.repositories.RadarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
public class RadarRestController {
    private RadarRepository radarRepository;
    private InfractionRestClient infractionRestClient;

    @GetMapping("/radars")
    public List<Radar> getAllRadars(){
        return radarRepository.findAll();
    }

    @GetMapping("/radars/{id}")
    public Radar getRadarById(@PathVariable Long id){
        return radarRepository.findRadarById(id);
    }

    @PostMapping("/radars")
    public Radar addRadar(@RequestBody Radar radar){
        return radarRepository.save(radar);
    }

    @PutMapping("/radars/{id}")
    public Radar updateRadar(@PathVariable Long id,@RequestBody Radar radar){
        Radar radar1 = radarRepository.findById(id).orElseThrow();
        radar1.setLongitude(radar.getLongitude());
        radar1.setLatitude(radar.getLatitude());
        radar1.setMaxSpeed(radar.getMaxSpeed());
        return radarRepository.save(radar1);
    }
    @PostMapping("/newInfraction")
    public boolean saveInfraction(@RequestBody NewInfraction newInfraction){
        infractionRestClient.addNewInfraction(newInfraction);
        return true;
    }
    @DeleteMapping ("/radars/{id}")
    public void deleteRadar(@PathVariable Long id){
        radarRepository.deleteById(id);
    }
}
