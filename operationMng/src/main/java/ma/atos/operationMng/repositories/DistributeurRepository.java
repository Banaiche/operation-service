package ma.atos.operationMng.repositories;


import ma.atos.operationMng.entites.Distributeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributeurRepository extends JpaRepository <Distributeur, Long> {

}
