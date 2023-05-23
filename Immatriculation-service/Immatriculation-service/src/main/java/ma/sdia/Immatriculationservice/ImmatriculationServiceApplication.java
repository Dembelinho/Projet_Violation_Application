package ma.sdia.Immatriculationservice;

import lombok.AllArgsConstructor;
import ma.sdia.Immatriculationservice.entities.Owner;
import ma.sdia.Immatriculationservice.entities.Vehicle;
import ma.sdia.Immatriculationservice.repositories.OwnerRepository;
import ma.sdia.Immatriculationservice.repositories.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication  @AllArgsConstructor
public class ImmatriculationServiceApplication implements CommandLineRunner {
	private OwnerRepository ownerRepository;
	private VehicleRepository vehicleRepository;
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ImmatriculationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(VehicleRepository.class);
		Stream.of("Ayoub","Mohammed","Messi").forEach(n->{
			Owner owner = Owner.builder().name(n)
					.email(n +"123@gmail.com").birthDay(String.valueOf(new Date()))
					.build();
			this.ownerRepository.save(owner);
		});

		Random random =new Random();
		ownerRepository.findAll().forEach(owner-> {
			Vehicle vehicle= Vehicle.builder()
					.owner(owner).model(random.nextInt(2000,2023))
					.registrationNumber(UUID.randomUUID().toString())
					.brand("RangeRover").fiscalPower(random.nextDouble(100,800))
					.build();
		    vehicleRepository.save(vehicle);

			vehicle.setFiscalPower(random.nextDouble(100,800));
			vehicle.setModel(random.nextInt(2000,2023));
			vehicle.setBrand("Mercedes");
			vehicle.setRegistrationNumber(UUID.randomUUID().toString());
			vehicleRepository.save(vehicle);

			vehicle.setFiscalPower(random.nextDouble(100,800));
			vehicle.setModel(random.nextInt(2000,2023));
			vehicle.setBrand("Ferrari");
			vehicle.setRegistrationNumber(UUID.randomUUID().toString());
			vehicleRepository.save(vehicle);
		});
	}
}
