package com.sdia.radarapplication;

import com.sdia.radarapplication.dto.NewInfraction;
import com.sdia.radarapplication.dto.Radar;
import com.sdia.radarapplication.dto.Vehicle;
import com.sdia.radarapplication.service.RestApi;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication @AllArgsConstructor
public class RadarApplication implements CommandLineRunner {
    private RestApi restTempServices;

    public static void main(String[] args) {
        SpringApplication.run(RadarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


                //getAllRadars
                Radar[] allRadars = restTempServices.getAllRadars();
                //getAllVehicles
                Vehicle[] allVehicles = restTempServices.getAllVehicles();

                Random random=new Random();
                //randomIndexes
                int indxRadar = random.nextInt(allRadars.length);
                int indxVehicle = random.nextInt(allVehicles.length);

                Radar selectedRadar=allRadars[indxRadar];
                Vehicle selectedVehicle= allVehicles[indxVehicle];


                //Generate Random Speed
                int vehicleSpeed=random.nextInt(selectedRadar.getMaxSpeed(),
                        selectedRadar.getMaxSpeed()+random.nextInt(100));

                //send New Infraction
                NewInfraction newInfraction = NewInfraction.builder().idRadar(selectedRadar.getId())
                        .regNbr(selectedVehicle.getRegistrationNumber())
                        .vehicleSpeed(vehicleSpeed).build();

                boolean results = restTempServices.sendInfraction(newInfraction);
                System.out.println(results);




    }
}
