package ma.sdia.Immatriculationservice.web.rest;

import lombok.AllArgsConstructor;
import ma.sdia.Immatriculationservice.entities.Owner;
import ma.sdia.Immatriculationservice.entities.Vehicle;
import ma.sdia.Immatriculationservice.repositories.OwnerRepository;
import ma.sdia.Immatriculationservice.repositories.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestControllerApi {
    private VehicleRepository vehicleRepository;
    private OwnerRepository ownerRepository;
//Owner parts -- Methods
    @GetMapping("/owners")
    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    @GetMapping("/owners/{id}")
    public Owner getOwnerById(@PathVariable long id){
        return ownerRepository.findOwnerById(id);
    }

    @PostMapping("/owners")
    public Owner addOwner(@RequestBody Owner owner){
        return ownerRepository.save(owner);
    }

    @PutMapping("/owners/update/{id}")
    public Owner updateOwner(@PathVariable long id, @RequestBody Owner owner){
        Owner owner1 = ownerRepository.findById(id).get();
        if (owner.getBirthDay() != null)owner1.setBirthDay(owner.getBirthDay());
        if (owner.getName() != null)owner1.setName(owner.getName());
        if (owner.getEmail() != null)owner1.setEmail(owner.getEmail());
        if (owner.getVehicles() != null)owner1.setVehicles(owner.getVehicles());
        return ownerRepository.save(owner1);
    }

    @DeleteMapping("/owners/delete/{id}")
    public void deleteOwner(@PathVariable long id){
        ownerRepository.deleteById(id);
    }
//Vehicle Parts -- Methods
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable String id){
        return vehicleRepository.findVehicleByRegNumb(id);

    }
    @GetMapping("/vehicles/brand/{brand}")
    public Collection<Vehicle> getVehicleByBrand(@PathVariable String brand){
        return vehicleRepository.findVehicleByBrand(brand);
    }
    @PostMapping("/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    @PutMapping("/vehicles/{id}")
    public Vehicle updateVehicle(@PathVariable String id,@RequestBody Vehicle vehicle){
        Vehicle vehicle1 = vehicleRepository.findVehicleByRegNumb(id);
        vehicle1.setBrand(vehicle.getBrand());
        {vehicle1.setModel(vehicle.getModel());}
        vehicle1.setOwner(vehicle.getOwner());
        vehicle1.setFiscalPower(vehicle.getFiscalPower());
        return vehicleRepository.save(vehicle1);
    }
    @DeleteMapping ("/vehicles/{id}")
    public void deleteVehicle(@PathVariable String id){
        vehicleRepository.deleteById(id);
    }

}
