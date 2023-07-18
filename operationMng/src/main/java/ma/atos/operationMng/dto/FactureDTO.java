package ma.atos.operationMng.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FactureDTO {

    private Long id;
    private String reference;
    private LocalDateTime date;
    private BigDecimal montant;
    private String statut;
}
