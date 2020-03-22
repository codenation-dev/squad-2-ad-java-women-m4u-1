package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.entity.User;
import br.com.codenation.centralerrosapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userRepository.saveAndFlush(user));

    }
}
