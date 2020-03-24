package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
