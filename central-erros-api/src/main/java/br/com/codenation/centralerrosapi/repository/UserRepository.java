package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
