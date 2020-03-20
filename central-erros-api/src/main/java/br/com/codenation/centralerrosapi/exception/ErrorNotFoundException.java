package br.com.codenation.centralerrosapi.exception;

import java.util.UUID;

public class ErrorNotFoundException
        extends RuntimeException {

    private UUID id;

    public ErrorNotFoundException(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "O erro com id="+ id.toString() + " não foi encontrado";
    }
}
