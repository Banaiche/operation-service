package ma.atos.operationMng.controllers;

import ma.atos.operationMng.dto.ClientDTO;
import ma.atos.operationMng.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/list")
    public List<ClientDTO> list() {

        List<ClientDTO> clientList = null;

        try {
            clientList = clientService.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientList;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ClientDTO> client(@PathVariable Long id) {

        ClientDTO client = null;

        try {
            client = clientService.getClientById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addClient(@RequestBody ClientDTO clientDTO) {
        clientService.addClient(clientDTO);
        return ResponseEntity.ok()
                .body(messageSource.getMessage("client.add.msg.succes",
                        new Object[]{clientDTO.getId()}
                        , Locale.FRENCH));

    }

    @GetMapping("/details/{id}")
    private ResponseEntity<ClientDTO> getClientDetails(@PathVariable Long id){
        ClientDTO client = clientService.getClientDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    /*
    @GetMapping("/by-facture/{factureId}")
    public ResponseEntity<ClientDTO> getClientByFactureId(@PathVariable Long factureId) {
        ClientDTO clientDTO = clientService.getClientByFactureId(factureId);
        if (clientDTO != null) {
            return ResponseEntity.ok(clientDTO);
        }
        return ResponseEntity.notFound().build();

     }

     */
}
