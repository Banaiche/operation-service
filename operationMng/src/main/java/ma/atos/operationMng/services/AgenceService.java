package ma.atos.operationMng.services;

import ma.atos.operationMng.dto.AgenceDTO;

import java.util.List;

public interface AgenceService {

    List<AgenceDTO> list();

    AgenceDTO getAgenceById(Long id);

    void addAgence(AgenceDTO agenceDTO);

}
