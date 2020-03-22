package br.com.codenation.centralerrosapi.controller;

import br.com.codenation.centralerrosapi.DTO.ErrorDTO;
import br.com.codenation.centralerrosapi.DTO.ErrorResponseDTO;
import br.com.codenation.centralerrosapi.DTO.LogDTO;
import br.com.codenation.centralerrosapi.entity.Error;
import br.com.codenation.centralerrosapi.exception.ErrorNotFoundException;
import br.com.codenation.centralerrosapi.service.interfaces.ErrorServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping(value = "/api")
@RestController
@Api(value = "API REST Errors")
@CrossOrigin(origins = "*")
public class ErrorController {

    private final ErrorServiceInterface errorService;

    public ErrorController(ErrorServiceInterface errorService) {
        this.errorService = errorService;
    }

    @GetMapping("/v1/errors")
    @ApiOperation(value = "Retorna uma lista com todos os erros")
    List<ErrorResponseDTO> getErro() {

        return errorService
                .getAll()
                .stream()
                .map(error -> new ModelMapper().map(error, ErrorResponseDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/v1/errors")
    @ApiOperation(value = "Salva um erro")
    Error newError(@Valid @RequestBody ErrorDTO errorDTO) {
        return errorService.save(new ModelMapper().map(errorDTO, Error.class));
    }

    @GetMapping("/v1/errors/{id}")
    @ApiOperation(value = "Retorna um erro especifico")
    ResponseEntity<LogDTO> getErroById(@PathVariable UUID id) {
        return errorService.getById(id)
                .map(error -> ResponseEntity.ok().body(new ModelMapper().map(error, LogDTO.class)))
                .orElseThrow(() -> new ErrorNotFoundException(id));
    }

    @GetMapping(value = "/v1/errors/environment/{environment}", params = {"order"})
    @ApiOperation(value = "Retorna uma lista por ambiente - order by: level ou frequency")
    List<Error> getByEnvironmentOrderBy(@PathVariable String environment,
                                        @RequestParam String order) {

        if (order.equals("frequency")) {
            return errorService.getByEnvironmentOrderByFrequency(environment);
        }

        if (order.equals("level")) {
            return errorService.getByEnvironmentOrderByLevel(environment);
        }

        return errorService.getByEnvironment(environment);
    }

    @GetMapping(value = "/v1/errors/environment/{environment}/{filter}", params = {"value", "order"})
    @ApiOperation("Retorna uma lista por ambiente e um filtro (origin, level, description) - order by: level ou frequency")
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
