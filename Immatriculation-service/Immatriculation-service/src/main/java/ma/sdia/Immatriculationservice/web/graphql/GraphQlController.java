package ma.sdia.Immatriculationservice.web.graphql;

import lombok.AllArgsConstructor;
import ma.sdia.Immatriculationservice.entities.Owner;
import ma.sdia.Immatriculationservice.entities.OwnerRequest;
import ma.sdia.Immatriculationservice.entities.Vehicle;
import ma.sdia.Immatriculationservice.repositories.OwnerRepository;
import ma.sdia.Immatriculationservice.repositories.VehicleRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller @AllArgsConstructor
public class GraphQlController {
    private OwnerRepository ownerRepository;
    private VehicleRepository vehicleRepository;

    // - Get all owners
    @QueryMapping
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    // - Get owner by id
    @QueryMapping
    public Owner getOwnerById(@Argument  long id){
        return ownerRepository.findOwnerById(id);
    }

    // - Save owner
    @MutationMapping
    public Owner addOwner(@Argument OwnerRequest owner){
        Owner o = new Owner();
        o.setName(owner.getName());
        o.setEmail(owner.getEmail());
        o.setBirthDay(owner.getBirthDay());
        return ownerRepository.save(o);
    }
    @MutationMapping
    public Boolean deleteOwner(@Argument Long id){
        ownerRepository.deleteById(id);
        return true;
    }

    // - Get all vehicles
    @QueryMapping
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    // - Get vehicle by id
    @QueryMapping
    public Vehicle getVehicleById(@Argument String id){
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicle %s not found ! ", id)));
    }

    // - Save vehicle
    @MutationMapping
    public Vehicle addVehicle(@Argument Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    // - Delete vehicle
    @MutationMapping
    public Boolean deleteVehicle(@Argument String id){
        vehicleRepository.deleteById(id);
        return true;
    }
}
