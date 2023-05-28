package ma.sdia.radarservice;

import lombok.AllArgsConstructor;
import ma.sdia.radarservice.entities.Radar;
import ma.sdia.radarservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication @AllArgsConstructor
@EnableFeignClients
public class RadarServiceApplication {
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(RadarServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(RadarRepository radarRepository){
		repositoryRestConfiguration.exposeIdsFor(Radar.class);
		return args -> {
			Random random=new Random();
			for (int i=0;i<4;i++){
				Radar radar= Radar.builder().Longitude(random.nextDouble(100))
						.MaxSpeed(132)
						.Latitude(random.nextDouble(200)).build();
				radarRepository.save(radar);
			}
		};
	}

}
