package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.entity.User;
import br.com.codenation.centralerrosapi.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/v1/users")
    @ApiOperation(value = "Retorna uma lista com todos os usuarios")
    public List<User> list(){
        return userRepository.findAll();
    }

    @PostMapping("/v1/users")
    @ApiOperation(value = "Salva um usuario")
    public ResponseEntity<?> save(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userRepository.saveAndFlush(user));
    }
}
