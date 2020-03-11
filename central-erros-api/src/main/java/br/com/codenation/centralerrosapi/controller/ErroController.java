package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.DTO.LogDTO;
import br.com.codenation.centralerrosapi.entity.Error;
import br.com.codenation.centralerrosapi.service.interfaces.ErroServiceInterface;
import javassist.expr.Cast;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping(value = "/erro-api/v1/erros/environment/{environment}")
    List<Error> getByEnvironment(@PathVariable String environment){
        return erroService.getByEnvironment(environment);
    }

    @GetMapping(value = "/erro-api/v1/erros/environment/{environment}", params = {"order"})
    List<Error> getByEnvironmentOrderBy(@PathVariable String environment,
                                        @RequestParam String order) {

        if(order.equals("frequency")) {
            return erroService.getByEnvironmentOrderByFrequency(environment);
        }

        if(order.equals("level")){
            return erroService.getByEnvironmentOrderByLevel(environment);
        }

        return null;
    }

    @GetMapping(value = "/erro-api/v1/erros/environment/{environment}/{filter}", params = {"value","order"} )
    List<Error> getByEnvironmentAndFilter(@PathVariable String environment,
                                          @PathVariable String filter,
                                          @RequestParam String value,
                                          @RequestParam String order) {
        if (filter.equals("level")) {

            if (order.isEmpty()) {
                return erroService.getByEnvironmentAndLevel(environment, value.charAt(0));
            } else if (order.equals("frequency")) {
                return erroService.getByEnvironmentAndLevelOrderByFrequency(environment, value.charAt(0));
            } else if (order.equals("level")) {
                return erroService.getByEnvironmentAndLevelOrderByLevel(environment, value.charAt(0));
            }

            return null;
        }

        if (filter.equals("description")){
            return erroService.getByEnvironmentAndDescription(environment, value);
        }

        if (filter.equals("origin")) {
            return erroService.getByEnvironmentAndOrigin(environment, value);
        }
        return null;
    }

}
