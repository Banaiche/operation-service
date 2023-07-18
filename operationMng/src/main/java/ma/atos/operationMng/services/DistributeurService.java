package ma.atos.operationMng.services;

import ma.atos.operationMng.dto.DistributeurDTO;

import java.util.List;

public interface DistributeurService {
    List<DistributeurDTO> list();

    void addDistributeur(DistributeurDTO distributeurDTO);

    DistributeurDTO findDistributeurById(Long id);
}
