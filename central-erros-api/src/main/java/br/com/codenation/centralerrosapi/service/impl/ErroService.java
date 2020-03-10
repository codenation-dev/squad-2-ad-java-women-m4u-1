package br.com.codenation.centralerrosapi.service.impl;

import br.com.codenation.centralerrosapi.entity.Error;
import br.com.codenation.centralerrosapi.repository.ErroRepository;
import br.com.codenation.centralerrosapi.service.interfaces.ErroServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ErroService implements ErroServiceInterface {

    private final ErroRepository errorRepository;

    public ErroService(ErroRepository erroRepository) {
        this.errorRepository = erroRepository;
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
    public List<Error> getByEnvironmentOrderByDescription(String environment) {
        return errorRepository.findByEnvironmentOrderByDescription(environment);
    }

}
