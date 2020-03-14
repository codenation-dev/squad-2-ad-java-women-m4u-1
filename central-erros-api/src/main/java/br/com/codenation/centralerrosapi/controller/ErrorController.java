package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.DTO.ErrorDTO;
import br.com.codenation.centralerrosapi.DTO.ErrorResponseDTO;
import br.com.codenation.centralerrosapi.DTO.LogDTO;
import br.com.codenation.centralerrosapi.entity.Error;
import br.com.codenation.centralerrosapi.service.interfaces.ErrorServiceInterface;
import javassist.expr.Cast;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ErrorController {

    private final ErrorServiceInterface errorService;

    public ErrorController(ErrorServiceInterface errorService) {
        this.errorService = errorService;
    }

    @GetMapping("/erro-api/v1/erros")
    List<ErrorResponseDTO> getErro(){
        return errorService.getAll().stream()
                .map(error -> new ErrorResponseDTO(error.getId(),
                        error.getEnvironment(),
                        error.getDescription(),
                        error.getLevel(),
                        error.getOrigin(),
                        error.getFrequency(),
                        error.getEventDate()))
                .collect(Collectors.toList());
    }

    @PostMapping("/error-api/v1/errors")
    Error newError(@RequestBody ErrorDTO errorDTO){
        return errorService.save(new ModelMapper().map(errorDTO, Error.class));
    }

    @GetMapping("/erro-api/v1/erros/{id}")
    ResponseEntity<LogDTO> getErroById(@PathVariable UUID id){
        return errorService.getById(id)
                            .map(error -> ResponseEntity.ok().body(new LogDTO(error.getId(), error.getLog())))
                            .orElse(null);
    }

    @GetMapping(value = "/erro-api/v1/erros/environment/{environment}")
    List<Error> getByEnvironment(@PathVariable String environment){
        return errorService.getByEnvironment(environment);
    }

    @GetMapping(value = "/erro-api/v1/erros/environment/{environment}", params = {"order"})
    List<Error> getByEnvironmentOrderBy(@PathVariable String environment,
                                        @RequestParam String order) {

        if(order.equals("frequency")) {
            return errorService.getByEnvironmentOrderByFrequency(environment);
        }

        if(order.equals("level")){
            return errorService.getByEnvironmentOrderByLevel(environment);
        }

        return null;
    }

    @GetMapping(value = "/erro-api/v1/erros/environment/{environment}/{filter}", params = {"value","order"} )
    List<Error> getByEnvironmentAndFilter(@PathVariable String environment,
                                          @PathVariable String filter,
                                          @RequestParam String value,
                                          @RequestParam String order) {
        if (filter.equals("level")) {

            if (order.isEmpty()) {
                return errorService.getByEnvironmentAndLevel(environment, value.charAt(0));
            } else if (order.equals("frequency")) {
                return errorService.getByEnvironmentAndLevelOrderByFrequency(environment, value.charAt(0));
            } else if (order.equals("level")) {
                return errorService.getByEnvironmentAndLevelOrderByLevel(environment, value.charAt(0));
            }

        }

        if (filter.equals("description")) {

            if (order.isEmpty()) {
                return errorService.getByEnvironmentAndDescription(environment, value);
            } else if (order.equals("frequency")) {
                return errorService.getByEnvironmentAndDescriptionOrderByFrequency(environment, value);
            } else if (order.equals("level")) {
                return errorService.getByEnvironmentAndDescriptionOrderByLevel(environment, value);
            }
        }

        if (filter.equals("origin")) {

            if (order.isEmpty()) {
                return errorService.getByEnvironmentAndOrigin(environment, value);
            } else if (order.equals("frequency")) {
                return errorService.getByEnvironmentAndOriginOrderByFrequency(environment, value);
            } else if (order.equals("level")) {
                return errorService.getByEnvironmentAndOriginOrderByLevel(environment, value);
            }
        }

        return null;
    }

}
