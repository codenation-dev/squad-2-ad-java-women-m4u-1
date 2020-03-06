package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventoRepository extends JpaRepository<Eventos, UUID> {

}
