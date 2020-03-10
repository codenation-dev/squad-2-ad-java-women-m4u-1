package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ErroRepository extends JpaRepository<Error, UUID> {

}
