package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.DTO.LogDTO;
import br.com.codenation.centralerrosapi.entity.Eventos;
import br.com.codenation.centralerrosapi.service.EventoServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.service.NullServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EventoController {

    private final EventoServiceInterface eventoService;

    public EventoController(EventoServiceInterface eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/erroApi/v1/eventos")
    List<Eventos> getEvento(){
        return eventoService.getAll();
    }

    @PostMapping("/erroApi/v1/eventos")
    Eventos novoEvento(@RequestBody Eventos evento){
        return eventoService.save(evento);
    }

    @GetMapping("/erroApi/v1/eventos/{id}")
    ResponseEntity<LogDTO> getEventoById(@PathVariable UUID id){
        return eventoService.getById(id)
                            .map(e -> ResponseEntity.ok().body(new LogDTO(e.getId(), e.getLog())))
                            .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

}
