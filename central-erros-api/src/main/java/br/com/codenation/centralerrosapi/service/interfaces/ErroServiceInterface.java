package br.com.codenation.centralerrosapi.service.interfaces;

import br.com.codenation.centralerrosapi.entity.Erro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ErroServiceInterface {

    List<Erro> getAll();
    Erro save(Erro erro);
    Optional<Erro> getById(UUID id);
}
