package ma.atos.operationMng.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistributeurDTO {

    private String reference;

    private List<AgenceDTO> agenceDTOList;

}
