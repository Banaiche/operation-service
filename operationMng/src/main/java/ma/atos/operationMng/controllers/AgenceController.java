package ma.atos.operationMng.controllers;

import ma.atos.operationMng.dto.AgenceDTO;
import ma.atos.operationMng.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/**
 * Agence controller
 */
@RestController
@RequestMapping("/agence")
public class AgenceController {

    @Autowired
    private AgenceService agenceService;

    @Autowired
    private MessageSource messageSource;


    /**
     * End point / Ressource
     */
    @GetMapping("/list")
    public List<AgenceDTO> list() {

        List<AgenceDTO> agenceList = null;

        try {
            agenceList = agenceService.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return agenceList;
    }

    @GetMapping("/getAgenceById/{id}")
    public AgenceDTO getAgenceById(@PathVariable Long id) {

        AgenceDTO agence = null;
        try {
            agence = agenceService.getAgenceById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agence;
    }
    @PostMapping("/add")
    public String addAgence(@RequestBody AgenceDTO agenceDTO){
        agenceService.addAgence(agenceDTO);
        return messageSource.getMessage("agence.add.msg.succes",new Object[] {agenceDTO.getId()}, Locale.FRENCH);
    }
}
