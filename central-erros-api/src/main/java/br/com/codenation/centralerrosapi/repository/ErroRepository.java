package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.entity.Erro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ErroRepository extends JpaRepository<Erro, UUID> {

}
