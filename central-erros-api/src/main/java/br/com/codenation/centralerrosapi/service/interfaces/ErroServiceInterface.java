package br.com.codenation.centralerrosapi.service.interfaces;

import br.com.codenation.centralerrosapi.entity.Error;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ErroServiceInterface {

    List<Error> getAll();
    
    Error save(Error error);
    
    Optional<Error> getById(UUID id);

}
