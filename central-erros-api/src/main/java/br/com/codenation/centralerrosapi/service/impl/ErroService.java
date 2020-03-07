package br.com.codenation.centralerrosapi.service.impl;

import br.com.codenation.centralerrosapi.entity.Erro;
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
    public List<Erro> getAll() {
        return erroRepository.findAll();
    }

    @Override
    public Erro save(Erro erro) {
        return erroRepository.save(erro);
    }

    @Override
    public Optional<Erro> getById(UUID id) {
        return erroRepository.findById(id);
    }

}
