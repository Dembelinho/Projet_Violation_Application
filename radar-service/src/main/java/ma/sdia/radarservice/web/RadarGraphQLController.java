package ma.sdia.radarservice.web;

import lombok.AllArgsConstructor;
import ma.sdia.radarservice.entities.Radar;
import ma.sdia.radarservice.repositories.RadarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class RadarGraphQLController {
    @Autowired
    private RadarRepository radarRepository;

    @QueryMapping
    public List<Radar> getAllRadars(){
        return radarRepository.findAll();
    }

    @QueryMapping
    public Radar getRadarById(@Argument Long id){
        return radarRepository.findRadarById(id);
    }

    @MutationMapping
    public Radar addRadar(@Argument Radar radar){
        return radarRepository.save(radar);
    }

    @MutationMapping
    public Radar updateRadar(@Argument Long id, @Argument Radar radar){
        Radar radar1 = radarRepository.findRadarById(id);
        radar1.setLongitude(radar.getLongitude());
        radar1.setLatitude(radar.getLatitude());
        radar1.setMaxSpeed(radar.getMaxSpeed());
        return radarRepository.save(radar1);
    }
    @MutationMapping
    public Boolean deleteRadar(@Argument Long id){
        radarRepository.deleteById(id);
        return true;
    }
}
