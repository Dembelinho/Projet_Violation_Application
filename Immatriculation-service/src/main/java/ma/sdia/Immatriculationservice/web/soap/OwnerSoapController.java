package ma.sdia.Immatriculationservice.web.soap;

import lombok.AllArgsConstructor;
import ma.sdia.Immatriculationservice.entities.Owner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/soap")
public class OwnerSoapController {
    private OwnerSoapService ownerSoapService;

    // Get all owners using soap
    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerSoapService.getOwners();
    }

    // Get owner by id using soap
    @GetMapping("/owners/{id}")
    public Owner getOwnerById(@PathVariable("id") Long id) {
        return ownerSoapService.getOwnerById(id);
    }
}
