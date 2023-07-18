package ma.atos.operationMng.services.impl;

import ma.atos.operationMng.dto.CaisseDTO;
import ma.atos.operationMng.entites.Caisse;
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

@Service
public class CaisseServiceImpl  implements CaisseService {
    @Autowired
    CaisseRepository caisseRepository;

    @Autowired
    ModelMapper modelMapper;

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

    /*
    @Override
    public CaisseDTO getCaisseById(Long id) {
        CaisseDTO caisseDTO= new CaisseDTO();
        Optional<Caisse> caisse = caisseRepository.findById(id);
        BeanUtils.copyProperties(caisse, caisseDTO);
        return caisseDTO;
    }

     */


    @Override
   public void addCaisse(CaisseDTO caisseDTO){
        Caisse caisse= new Caisse();
        BeanUtils.copyProperties(caisseDTO,caisse);
        caisseRepository.save(caisse);
    }

    @Override
    public CaisseDTO getCaisseById(Long caisseId) {
        Optional<Caisse> caisse = caisseRepository.findById(caisseId);
        CaisseDTO caisseDTO = modelMapper.map(caisse,CaisseDTO.class);
        return caisseDTO;
    }

}
