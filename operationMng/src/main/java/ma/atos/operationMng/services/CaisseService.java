package ma.atos.operationMng.services;

import ma.atos.operationMng.dto.CaisseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CaisseService {
    List<CaisseDTO> list();
    CaisseDTO getCaisseById(Long id);
    void addCaisse(CaisseDTO caisseDTO);

}
