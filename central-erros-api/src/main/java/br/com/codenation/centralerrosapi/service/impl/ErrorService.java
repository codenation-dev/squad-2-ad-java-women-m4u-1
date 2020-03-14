package br.com.codenation.centralerrosapi.service.impl;

import br.com.codenation.centralerrosapi.entity.Error;
import br.com.codenation.centralerrosapi.repository.ErrorRepository;
import br.com.codenation.centralerrosapi.service.interfaces.ErrorServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ErrorService implements ErrorServiceInterface {

    private final ErrorRepository errorRepository;

    public ErrorService(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    @Override
    public List<Error> getAll() {
        return errorRepository.findAll();
    }

    @Override
    public Error save(Error error) {
        return errorRepository.save(error);
    }

    @Override
    public Optional<Error> getById(UUID id) {
        return errorRepository.findById(id);
    }

    @Override
    public List<Error> getByEnvironment(String environment) {
        return errorRepository.findByEnvironment(environment);
    }

    @Override
    public List<Error> getByEnvironmentOrderByFrequency(String environment) {
        return errorRepository.findByEnvironmentOrderByFrequency(environment);
    }

    @Override
    public List<Error> getByEnvironmentOrderByLevel(String environment) {
        return errorRepository.findByEnvironmentOrderByLevel(environment);
    }

    @Override
    public List<Error> getByEnvironmentAndLevel(String environment, char level) {
        return errorRepository.findByEnvironmentAndLevel(environment, level);
    }

    @Override
    public List<Error> getByEnvironmentAndDescription(String environment, String value) {
        return errorRepository.findByEnvironmentAndDescription(environment, value);
    }

    @Override
    public List<Error> getByEnvironmentAndLevelOrderByFrequency(String environment, char value) {
        return errorRepository.findByEnvironmentAndLevelOrderByFrequency(environment, value);
    }

    @Override
    public List<Error> getByEnvironmentAndLevelOrderByLevel(String environment, char value) {
        return errorRepository.findByEnvironmentAndLevelOrderByLevel(environment, value);
    }

    @Override
    public List<Error> getByEnvironmentAndOrigin(String environment, String value) {
        return errorRepository.findByEnvironmentAndOrigin(environment, value);
    }

    @Override
    public List<Error> getByEnvironmentAndDescriptionOrderByFrequency(String environment, String value) {
        return errorRepository.findByEnvironmentAndDescriptionOrderByFrequency(environment, value);
    }

    @Override
    public List<Error> getByEnvironmentAndDescriptionOrderByLevel(String environment, String value) {
        return errorRepository.findByEnvironmentAndDescriptionOrderByLevel(environment, value);
    }

    @Override
    public List<Error> getByEnvironmentAndOriginOrderByFrequency(String environment, String value) {
        return errorRepository.findByEnvironmentAndOriginOrderByFrequency(environment, value);
    }

    @Override
    public List<Error> getByEnvironmentAndOriginOrderByLevel(String environment, String value) {
        return errorRepository.findByEnvironmentAndOriginOrderByLevel(environment, value);
    }


}
