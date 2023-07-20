package ma.atos.operationMng.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CaisseDTO {

    private long id;
    private String etat;
    private BigDecimal montant;
   private Long agenceId;
   public Long getAgenceId(){
       return agenceId;
   }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }
}
