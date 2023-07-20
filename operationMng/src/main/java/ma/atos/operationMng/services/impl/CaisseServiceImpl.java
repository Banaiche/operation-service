package ma.atos.operationMng.services.impl;

import ma.atos.operationMng.dto.AgenceDTO;
import ma.atos.operationMng.dto.CaisseDTO;
import ma.atos.operationMng.entites.Agence;
import ma.atos.operationMng.entites.Caisse;
import ma.atos.operationMng.repositories.AgenceRepository;
import ma.atos.operationMng.repositories.CaisseRepository;
import ma.atos.operationMng.services.CaisseService;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CaisseServiceImpl  implements CaisseService {
    @Autowired
    CaisseRepository caisseRepository;
    @Autowired
    AgenceRepository agenceRepository;

    @Override
    public List<CaisseDTO> list(){
        List<Caisse> caisseList= caisseRepository.findAll();
        List<CaisseDTO> caisseDTOList= new ArrayList<>();
        if (!CollectionUtils.isEmpty(caisseList)){
            caisseList.stream().forEach(caisse -> {
                CaisseDTO caisseDTO = new CaisseDTO();
                BeanUtils.copyProperties(caisse, caisseDTO);
                caisseDTOList.add(caisseDTO);
            });
        }
                return caisseDTOList;
    }

    @Override
    public CaisseDTO getCaisseById(Long id) {
        CaisseDTO caisseDTO= new CaisseDTO();
       Caisse caisse = caisseRepository.findById(id).get();
        BeanUtils.copyProperties(caisse, caisseDTO);
        return caisseDTO;
    }

    @Override
    public void saveCaisse(CaisseDTO caisseDTO) {
        Caisse caisse= new Caisse();
        caisse.setId(caisseDTO.getId());
        caisse.setEtat(caisseDTO.getEtat());
        caisse.setMontant(caisseDTO.getMontant());

        Agence agence=agenceRepository.
                findById(caisseDTO.getAgenceId())
                .orElse(null);
        caisse.setAgence(agence);
        caisseRepository.save(caisse);

    }

//   public void Ajout(CaisseDTO caisseDTO){
//        Caisse caisse= new Caisse();
//        Agence agence= new Agence();
//        if (caisseRepository.existsById(caisseDTO.getId())) {
//            throw new IllegalArgumentException("Caisse avec cet ID existe déjà");
//        }
//        //caisse.setAgence(agence);
//        // Copier les propriétés de CaisseDTO à Caisse
//        BeanUtils.copyProperties(caisseDTO, caisse);
//
//        // Ajouter la nouvelle caisse
//        caisseRepository.save(caisse);
//    }

}
