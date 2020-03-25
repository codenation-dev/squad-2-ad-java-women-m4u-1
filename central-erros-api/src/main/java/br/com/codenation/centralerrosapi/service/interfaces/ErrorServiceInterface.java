package br.com.codenation.centralerrosapi.service.interfaces;

import br.com.codenation.centralerrosapi.entity.Error;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ErrorServiceInterface {

    List<Error> getAll();
    
    Error save(Error error);
    
    Optional<Error> getById(UUID id);

    List<Error> getByEnvironment(String environment);

    List<Error> getByEnvironmentOrderByFrequency(String environment);

    List<Error> getByEnvironmentOrderByLevel(String environment);

    List<Error> getByEnvironmentAndLevel(String environment, char level);

    List<Error> getByEnvironmentAndDescription(String environment, String value);

    List<Error> getByEnvironmentAndLevelOrderByFrequency(String environment, char value);

    List<Error> getByEnvironmentAndLevelOrderByLevel(String environment, char value);

    List<Error> getByEnvironmentAndOrigin(String environment, String value);

    List<Error> getByEnvironmentAndDescriptionOrderByFrequency(String environment, String charAt);

    List<Error> getByEnvironmentAndDescriptionOrderByLevel(String environment, String charAt);

    List<Error> getByEnvironmentAndOriginOrderByFrequency(String environment, String charAt);

    List<Error> getByEnvironmentAndOriginOrderByLevel(String environment, String charAt);

}
