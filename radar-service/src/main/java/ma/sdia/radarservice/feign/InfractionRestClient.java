package ma.sdia.radarservice.feign;

import ma.sdia.radarservice.models.Infraction;
import ma.sdia.radarservice.models.NewInfraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "infraction-service")
public interface InfractionRestClient {
    @PostMapping("/infractions/add")
    Infraction addNewInfraction(@RequestBody NewInfraction newInfraction);
}
