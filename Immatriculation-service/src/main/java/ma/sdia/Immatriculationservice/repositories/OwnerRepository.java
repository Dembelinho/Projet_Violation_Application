package ma.sdia.Immatriculationservice.repositories;


import ma.sdia.Immatriculationservice.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner,Long> {

    @Query("select o from Owner o where o.id = :id")
    Owner findOwnerById(@Param("id") long id);


}
