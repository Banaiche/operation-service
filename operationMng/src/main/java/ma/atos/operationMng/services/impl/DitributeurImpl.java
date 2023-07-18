package ma.atos.operationMng.services.impl;

import ma.atos.operationMng.dto.DistributeurDTO;
import ma.atos.operationMng.entites.Distributeur;
import ma.atos.operationMng.repositories.DistributeurRepository;
import ma.atos.operationMng.services.DistributeurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DitributeurImpl implements DistributeurService {

    @Autowired
    private DistributeurRepository distributeurRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DistributeurDTO> list() {
        List<Distributeur> distributeurList = distributeurRepository.findAll();
        List<DistributeurDTO> distributeurDTOList= new ArrayList<>();
        if (!CollectionUtils.isEmpty(distributeurList)){
            distributeurList.forEach(distributeur -> {
                DistributeurDTO distributeurDTO = new DistributeurDTO();
                BeanUtils.copyProperties(distributeur, distributeurDTO);
                distributeurDTOList.add(distributeurDTO);
            });
        }
        return distributeurDTOList;

    }

    @Override
    public void addDistributeur(DistributeurDTO distributeurDTO) {
        Distributeur distributeur = new Distributeur();
        BeanUtils.copyProperties(distributeurDTO, distributeur);
        distributeurRepository.save(distributeur);
    }

    @Override
    public DistributeurDTO findDistributeurById(Long id) {

        Optional<Distributeur> distributeur = distributeurRepository.findById(id);

        DistributeurDTO distributeurDTO = modelMapper.map(distributeur, DistributeurDTO.class);

        return distributeurDTO;
    }




}
