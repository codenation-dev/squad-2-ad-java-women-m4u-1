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

    private final ErroRepository erroRepository;

    public ErroService(ErroRepository erroRepository) {
        this.erroRepository = erroRepository;
    }

    @Override
    public List<Error> getAll() {
        return erroRepository.findAll();
    }

    @Override
    public Error save(Error error) {
        return erroRepository.save(error);
    }

    @Override
    public Optional<Error> getById(UUID id) {
        return erroRepository.findById(id);
    }

}
