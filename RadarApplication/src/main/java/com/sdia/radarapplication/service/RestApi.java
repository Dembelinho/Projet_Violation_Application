package com.sdia.radarapplication.service;

import com.sdia.radarapplication.dto.NewInfraction;
import com.sdia.radarapplication.dto.Radar;
import com.sdia.radarapplication.dto.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@AllArgsConstructor
@Service
public class RestApi {
    private RestTemplate restTemplate;
    public Radar[] getAllRadars(){
        String url="http://localhost:8888/RADAR-SERVICE/radars";
        Radar[] radar = restTemplate.getForObject(url, Radar[].class);

        return radar;
    }
    public Vehicle[] getAllVehicles(){
        String url="http://localhost:8888/IMMATRICULATION-SERVICE/vehicles";
        Vehicle[] vehicles= restTemplate.getForObject(url, Vehicle[].class);
        System.out.println(vehicles.length);
        return vehicles;
    }
    public boolean sendInfraction(NewInfraction newInfraction){
        String url="http://localhost:8888/RADAR-SERVICE/newInfraction";
        Boolean result = restTemplate.postForObject(url, newInfraction, Boolean.class);
        return result;
    }
}
