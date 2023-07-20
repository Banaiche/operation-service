package ma.atos.operationMng.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AgenceDTO {

    private Long id;
    private String nom;
    private String localisation;
    private List<ClientDTO> clientList;
    private DistributeurDTO distributeurDTO;
    private CaisseDTO caisseDTO;


}
