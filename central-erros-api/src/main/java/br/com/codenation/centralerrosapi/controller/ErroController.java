package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.DTO.LogDTO;
import br.com.codenation.centralerrosapi.entity.Erro;
import br.com.codenation.centralerrosapi.service.ErroServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;
import java.util.UUID;

@RestController
public class ErroController {

    private final ErroServiceInterface erroService;

    public ErroController(ErroServiceInterface erroService) {
        this.erroService = erroService;
    }

    @GetMapping("/erro-api/v1/erros")
    List<Erro> getEvento(){
        return erroService.getAll();
    }

    @PostMapping("/erro-api/v1/erros")
    Erro novoErro(@RequestBody Erro erro){
        return erroService.save(erro);
    }

    @GetMapping("/erro-api/v1/erros/{id}")
    ResponseEntity<LogDTO> getErroById(@PathVariable UUID id){
        return erroService.getById(id)
                            .map(erro -> ResponseEntity.ok().body(new LogDTO(erro.getId(), erro.getLog())))
                            .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

}
