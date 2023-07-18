package ma.atos.operationMng.dto;

import lombok.Getter;
import lombok.Setter;
import ma.atos.operationMng.enums.TypePaiement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDTO {

    private Long id;
    private TypePaiement typePaiement;
    private BigDecimal montant;
    private LocalDateTime date;
    private boolean isRapprochement;

}
