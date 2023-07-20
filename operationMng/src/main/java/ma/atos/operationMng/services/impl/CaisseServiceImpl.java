package ma.atos.operationMng.services.impl;

import ma.atos.operationMng.dto.CaisseDTO;
import ma.atos.operationMng.entites.Agence;
import ma.atos.operationMng.entites.Caisse;
import ma.atos.operationMng.repositories.AgenceRepository;
import ma.atos.operationMng.repositories.CaisseRepository;
import ma.atos.operationMng.services.CaisseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaisseServiceImpl  implements CaisseService {
    @Autowired
    CaisseRepository caisseRepository;
    @Autowired
    AgenceRepository agenceRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CaisseDTO> list() {
        List<Caisse> caisses = caisseRepository.findAll();

        // Mapper les entités Caisse vers des objets CaisseDTO
        List<CaisseDTO> caisseDTOs = caisses.stream()
                .map(caisse -> modelMapper.map(caisse, CaisseDTO.class))
                .collect(Collectors.toList());

        return caisseDTOs;
    }
//    @Override
//    public List<CaisseDTO> list(){
//        List<Caisse> caisseList= caisseRepository.findAll();
//        List<CaisseDTO> caisseDTOList= new ArrayList<>();
//        if (!CollectionUtils.isEmpty(caisseList)){
//            caisseList.stream().forEach(caisse -> {
//                CaisseDTO caisseDTO = new CaisseDTO();
//                BeanUtils.copyProperties(caisse, caisseDTO);
//                caisseDTOList.add(caisseDTO);
//            });
//        }
//                return caisseDTOList;
//    }

    /*
    @Override
    public CaisseDTO getCaisseById(Long id) {
        CaisseDTO caisseDTO= new CaisseDTO();
        Optional<Caisse> caisse = caisseRepository.findById(id);
        BeanUtils.copyProperties(caisse, caisseDTO);
        return caisseDTO;
    }

     */

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
//


    @Override
    public CaisseDTO getCaisseById(Long caisseId) {
        Optional<Caisse> caisse = caisseRepository.findById(caisseId);
        CaisseDTO caisseDTO = modelMapper.map(caisse,CaisseDTO.class);
        return caisseDTO;
    }

}
