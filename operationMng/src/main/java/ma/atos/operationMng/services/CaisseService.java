package ma.atos.operationMng.services;

import ma.atos.operationMng.dto.CaisseDTO;

import java.util.List;


public interface CaisseService {
    List<CaisseDTO> list();
    // CaisseDTO getCaisseById(Long id);
    void saveCaisse(CaisseDTO caisseDTO);

    CaisseDTO getCaisseById(Long caisseId);

}
