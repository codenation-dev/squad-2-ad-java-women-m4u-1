package br.com.codenation.centralerrosapi.service.interfaces;

import br.com.codenation.centralerrosapi.entity.Error;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ErroServiceInterface {

    List<Error> getAll();
    
    Error save(Error error);
    
    Optional<Error> getById(UUID id);

    List<Error> getByEnvironment(String environment);

    List<Error> getByEnvironmentOrderByFrequency(String environment);

    List<Error> getByEnvironmentOrderByLevel(String environment);

    List<Error> getByEnvironmentAndLevel(String environment, char level);

    List<Error> getByEnvironmentAndDescription(String environment, String value);

    List<Error> getByEnvironmentAndFrequency(String environment, int value);

    List<Error> getByEnvironmentAndLevelOrderByFrequency(String environment, char value);

    List<Error> getByEnvironmentAndLevelOrderByLevel(String environment, char value);

}
