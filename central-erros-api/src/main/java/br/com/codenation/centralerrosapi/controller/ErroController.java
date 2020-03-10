package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.DTO.LogDTO;
import br.com.codenation.centralerrosapi.entity.Error;
import br.com.codenation.centralerrosapi.service.interfaces.ErroServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ErroController {

    private final ErroServiceInterface erroService;

    public ErroController(ErroServiceInterface erroService) {
        this.erroService = erroService;
    }

    @GetMapping("/erro-api/v1/erros")
    List<Error> getErro(){
        return erroService.getAll();
    }

    @PostMapping("/erro-api/v1/erros")
    Error novoErro(@RequestBody Error error){
        return erroService.save(error);
    }

    @GetMapping("/erro-api/v1/erros/{id}")
    ResponseEntity<LogDTO> getErroById(@PathVariable UUID id){
        return erroService.getById(id)
                            .map(error -> ResponseEntity.ok().body(new LogDTO(error.getId(), error.getLog())))
                            .orElse(null);
    }

    @GetMapping(value = "/erro-api/v1/erros", params = {"environment", "order"})
    List<Error> getByEnvironmentOrderBy(@RequestParam String environment,
                                       @RequestParam String order) {

        if(order.equals("frequency")) {
            return erroService.getByEnvironmentOrderByFrequency(environment);
        }

        if(order.equals("level")){
            return erroService.getByEnvironmentOrderByLevel(environment);
        }

        if(order.equals("description")){
            return erroService.getByEnvironmentOrderByDescription(environment);
        }

        return null;
    }

    @GetMapping(value = "/erro-api/v1/erros/", params = "environment")
    List<Error> getByOrigem(@RequestParam String environment){
        return erroService.getByEnvironment(environment);
    }

}
