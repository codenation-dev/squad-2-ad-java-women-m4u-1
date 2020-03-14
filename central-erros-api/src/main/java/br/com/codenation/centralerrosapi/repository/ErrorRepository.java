package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ErrorRepository extends JpaRepository<Error, UUID> {

    List<Error> findByEnvironment(String environment);

    List<Error> findByEnvironmentOrderByFrequency(String environment);

    List<Error> findByEnvironmentOrderByLevel(String environment);

    List<Error> findByEnvironmentAndLevel(String environment, char level);

    List<Error> findByEnvironmentAndDescription(String environment, String value);

    List<Error> findByEnvironmentAndLevelOrderByFrequency(String environment, char charAt);

    List<Error> findByEnvironmentAndLevelOrderByLevel(String environment, char value);

    List<Error> findByEnvironmentAndOrigin(String environment, String value);

    List<Error> findByEnvironmentAndDescriptionOrderByFrequency(String environment, String value);

    List<Error> findByEnvironmentAndDescriptionOrderByLevel(String environment, String value);

    List<Error> findByEnvironmentAndOriginOrderByFrequency(String environment, String value);

    List<Error> findByEnvironmentAndOriginOrderByLevel(String environment, String value);
}
