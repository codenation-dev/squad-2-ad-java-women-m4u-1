package br.com.codenation.centralerrosapi.service;

import br.com.codenation.centralerrosapi.entity.Eventos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventoServiceInterface {

    List<Eventos> getAll();
    Eventos save(Eventos evento);
    Optional<Eventos> getById(UUID id);
}
