package br.com.codenation.centralerrosapi.repository;

import br.com.codenation.centralerrosapi.DTO.UserCustomDTO;
import br.com.codenation.centralerrosapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface  UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
