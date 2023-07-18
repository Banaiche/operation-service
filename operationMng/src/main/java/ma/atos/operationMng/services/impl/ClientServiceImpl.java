package ma.atos.operationMng.services.impl;

import ma.atos.operationMng.dto.AgenceDTO;
import ma.atos.operationMng.dto.CaisseDTO;
import ma.atos.operationMng.dto.ClientDTO;
import ma.atos.operationMng.dto.FactureDTO;
import ma.atos.operationMng.entites.*;
import ma.atos.operationMng.enums.TypeClient;
import ma.atos.operationMng.proxies.FactureProxy;
import ma.atos.operationMng.repositories.ClientRepository;
import ma.atos.operationMng.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FactureProxy factureProxy;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<ClientDTO> list() {

        List<Client> clientList = clientRepository.findAll();

        List<ClientDTO> clientDTOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(clientDTOList)) {
            clientList.stream().forEach(client -> {
                ClientDTO clientDTO = new ClientDTO();
                BeanUtils.copyProperties(client, clientDTO);
                clientDTOList.add(clientDTO);
            });
        }

        return clientDTOList;
    }


    @Override
    public ClientDTO getClientById(Long id) {

        Optional<Client> client = clientRepository.findById(id);

        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);

        return clientDTO;
    }

    @Override
    public ClientDTO getClientDetails(Long id) {

        Optional<Client> client = clientRepository.findById(id);
        ClientDTO clientResponse = modelMapper.map(client, ClientDTO.class);

        // 1 - Appel API par RestTemplate
        // FactureDTO factureResponse = restTemplate.getForObject("http://localhost:8081/facture/details/{id}", FactureDTO.class, id);


        // 1 - Appel API par FeignClient

        ResponseEntity<FactureDTO> factureResponse =  factureProxy.getFactureByClientId(id);

        if (factureResponse != null) {
            clientResponse.setFactureDTO(factureResponse.getBody());
        }

        return clientResponse;
    }


    /*
        @Override
        public ClientDTO getClientByFactureId(Long factureId) {

            ResponseEntity<ClientDTO> response = restTemplate.exchange(
                    "http://localhost:8080/facture/get/{factureId}",
                    HttpMethod.GET,
                    null,
                    //this one is just for converting data from entity to ClientDTO ! don't worry !
                    new ParameterizedTypeReference<ClientDTO>() {},
                    factureId);
            if (response.getStatusCode() == HttpStatus.OK) {

                ClientDTO clientDTO = response.getBody();


                FactureDTO factureDTO = restTemplate.getForObject("http://localhost:8080/facture/get/{id}", FactureDTO.class, factureId);

                clientDTO.setFactureDTO(factureDTO);

                return response.getBody();

            } else {
                System.out.println("Not Working ! ");
                return null;
            }
        }

     */
    @Override
    public void addClient(ClientDTO clientDTO) {

        if (clientDTO.getTypeClient().equals(TypeClient.B2B)) {
            B2B b2b = new B2B();
            BeanUtils.copyProperties(clientDTO, b2b);
            clientRepository.save(b2b);

        } else {
            B2C b2C = new B2C();
            BeanUtils.copyProperties(clientDTO, b2C);
            clientRepository.save(b2C);

        }
    }
}
