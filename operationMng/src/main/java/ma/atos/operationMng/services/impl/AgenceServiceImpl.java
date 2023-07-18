package ma.atos.operationMng.services.impl;

import ma.atos.operationMng.dto.AgenceDTO;
import ma.atos.operationMng.dto.ClientDTO;
import ma.atos.operationMng.entites.Agence;
import ma.atos.operationMng.repositories.AgenceRepository;
import ma.atos.operationMng.services.AgenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgenceServiceImpl implements AgenceService {

    @Autowired
    AgenceRepository agenceRepository;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<AgenceDTO> list() {

        // Return all agencies exist in DB
        List<Agence> agenceList =  agenceRepository.findAll();

        List<AgenceDTO> agenceDTOList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(agenceList)) {
            agenceList.forEach(agence -> {
                AgenceDTO agenceDTO = new AgenceDTO();
                BeanUtils.copyProperties(agence, agenceDTO);
                agenceDTOList.add(agenceDTO);
            });
        }

        return agenceDTOList;
    }

    @Override
    public AgenceDTO getAgenceById(Long id) {

        Optional<Agence> agence = agenceRepository.findById(id);
        AgenceDTO agenceDTO = modelMapper.map(agence, AgenceDTO.class);
        return agenceDTO;
    }


    @Override
    public void addAgence(AgenceDTO agenceDTO) {

        Agence agence = new Agence();
        BeanUtils.copyProperties(agenceDTO, agence);
        agenceRepository.save(agence);

    }

}
