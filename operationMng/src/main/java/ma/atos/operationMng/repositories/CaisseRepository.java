package ma.atos.operationMng.repositories;

import ma.atos.operationMng.entites.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse, Long> {


}
