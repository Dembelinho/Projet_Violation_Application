package ma.sdia.Immatriculationservice.repositories;

import ma.sdia.Immatriculationservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    @Query("select v from Vehicle v where v.registrationNumber=:registration")
    Vehicle findVehicleByRegNumb(@Param("registration") String registration);

    @Query("select v from Vehicle v where v.brand=:brand")
    Collection<Vehicle> findVehicleByBrand(@Param("brand")String brand);


}
