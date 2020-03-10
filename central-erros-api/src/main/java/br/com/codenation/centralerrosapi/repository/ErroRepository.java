package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ErroRepository extends JpaRepository<Error, UUID> {

    List<Error> findByEnvironment(String environment);

    List<Error> findByEnvironmentOrderByFrequency(String environment);

    List<Error> findByEnvironmentOrderByLevel(String environment);

    List<Error> findByEnvironmentOrderByDescription(String environment);

}
