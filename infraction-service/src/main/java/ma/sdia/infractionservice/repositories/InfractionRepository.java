package ma.sdia.infractionservice.repositories;

import ma.sdia.infractionservice.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction,Long> {
}
