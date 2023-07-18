package ma.atos.operationMng.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class B2BDTO extends ClientDTO {

    private String registreCommerce;
    private String patente;
    private String fax;
    private String raisonSocial;
}
