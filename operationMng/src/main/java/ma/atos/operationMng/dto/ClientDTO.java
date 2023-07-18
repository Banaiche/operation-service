package ma.atos.operationMng.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.atos.operationMng.enums.TypeClient;

import java.util.List;

@Getter
@Setter
public class ClientDTO{

    private Long id;
    private String adresse;
    private TypeClient typeClient;
    private AgenceDTO agence;

    private FactureDTO factureDTO;


}
