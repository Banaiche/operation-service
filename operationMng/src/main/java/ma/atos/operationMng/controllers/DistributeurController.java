package ma.atos.operationMng.controllers;


import ma.atos.operationMng.dto.DistributeurDTO;
import ma.atos.operationMng.services.DistributeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributeur")
public class DistributeurController {

    @Autowired
    private DistributeurService distributeurService;

    @GetMapping("/list")
    public List<DistributeurDTO> listdistributeur(){
        return distributeurService.list();
    }

    @PostMapping("/add")
    public String addDistributeur (@RequestBody DistributeurDTO distributeurDTO){
        distributeurService.addDistributeur(distributeurDTO);
        return "done ";
    }

    @GetMapping("/get/{id}")
    public DistributeurDTO getDistributeurByReference(@PathVariable Long id){
        DistributeurDTO distributeur = distributeurService.findDistributeurById(id);

        return distributeur;
    }

}
