package ma.atos.operationMng.controllers;

import ma.atos.operationMng.dto.CaisseDTO;
import ma.atos.operationMng.entites.Caisse;
import ma.atos.operationMng.services.CaisseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("caisse")
public class CaisseController {
    @Autowired
    private CaisseService caisseService;

    @GetMapping("/list")
    public List<CaisseDTO> list()
    {
        List<CaisseDTO> caisselist= null;
        try{
            caisselist= caisseService.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return caisselist;

    }

    @GetMapping("/get/{id}")
    public CaisseDTO getCaisseById(@PathVariable(name = "id") Long id) {
        CaisseDTO caisse = null;
        try{
            caisse=caisseService.getCaisseById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return caisse;
    }

    @PostMapping("/add")
    public String addCaisse (@RequestBody CaisseDTO caisseDTO){
        caisseService.addCaisse(caisseDTO);
        return "Les données sont bien enregistrer";

    }

}
