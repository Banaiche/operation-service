package ma.atos.operationMng.services;


import ma.atos.operationMng.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    List<ClientDTO> list();

    ClientDTO getClientById(Long id);

    ClientDTO getClientDetails(Long id);

    void addClient(ClientDTO clientDTO);

}
