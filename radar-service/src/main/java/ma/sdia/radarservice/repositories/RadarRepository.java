package ma.sdia.radarservice.repositories;

import ma.sdia.radarservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public interface RadarRepository extends JpaRepository<Radar,Long> {
    @Query("select r from Radar r where r.id= :id")
    Radar findRadarById(@Param("id") long id);
}
