package ma.atos.operationMng.proxies;


import ma.atos.operationMng.dto.FactureDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "factureProxy", url = "${facture.api.url:http://localhost:8081/facture/}")
public interface FactureProxy {

    @GetMapping("details/{clientId}")
    ResponseEntity<FactureDTO> getFactureByClientId(@PathVariable("clientId") Long clientId);

}
