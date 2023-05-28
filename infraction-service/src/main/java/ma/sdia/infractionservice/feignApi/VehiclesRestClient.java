package ma.sdia.infractionservice.feignApi;

import ma.sdia.infractionservice.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (name = "immatriculation-service")
public interface VehiclesRestClient {
    @GetMapping(path = "/vehicles")
    List<Vehicle> getAllVehicles();


    @GetMapping("/vehicles/{id}")
    Vehicle getVehicleById(@PathVariable String id);


}
