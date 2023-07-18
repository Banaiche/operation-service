package ma.atos.operationMng.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.atos.operationMng.entites.Agence;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Getter
@Setter
public class CaisseDTO {

    private long id;
    private String etat;
    private BigDecimal montant;
    private AgenceDTO agence;

}
