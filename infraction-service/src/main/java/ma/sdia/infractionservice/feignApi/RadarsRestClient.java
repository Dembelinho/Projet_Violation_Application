package ma.sdia.infractionservice.feignApi;

import ma.sdia.infractionservice.models.Radar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "radar-service")
public interface RadarsRestClient {
    @GetMapping(path = "/radars")
    List<Radar> getAllRadars();

    @GetMapping("/radars/{id}")
    Radar getRadarById(@PathVariable Long id);

}
