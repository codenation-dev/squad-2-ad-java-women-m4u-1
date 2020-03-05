package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.entity.Eventos;
import br.com.codenation.centralerrosapi.service.EventoServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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

}
