package br.com.codenation.centralerrosapi.service;

import br.com.codenation.centralerrosapi.entity.Eventos;

import java.util.List;

public interface EventoServiceInterface {

    List<Eventos> getAll();
    Eventos save(Eventos evento);

}
