package br.com.codenation.centralerrosapi.exception;

import br.com.codenation.centralerrosapi.DTO.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ErrorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    MessageDTO errorNotFoundHandler(ErrorNotFoundException e) {
        return new MessageDTO(e.toString());
    }
}
