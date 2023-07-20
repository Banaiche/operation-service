package ma.atos.operationMng.repositories;

import ma.atos.operationMng.entites.Caisse;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse, Long> {

   /* @Query(nativeQuery = true,
            value = "select c from caisse c where c.id=:caisseId")
    Caisse getCaisseById(@Param("caisseId") Long caisseId);
    */

}
