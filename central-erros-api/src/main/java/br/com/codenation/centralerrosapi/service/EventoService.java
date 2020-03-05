package br.com.codenation.centralerrosapi.service;

import br.com.codenation.centralerrosapi.entity.Eventos;
import br.com.codenation.centralerrosapi.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService implements EventoServiceInterface {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<Eventos> getAll() {
        return eventoRepository.findAll();
    }

    @Override
    public Eventos save(Eventos evento) {
        return eventoRepository.save(evento);
    }
}
