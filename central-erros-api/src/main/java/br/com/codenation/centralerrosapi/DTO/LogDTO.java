package br.com.codenation.centralerrosapi.DTO;

import br.com.codenation.centralerrosapi.entity.Eventos;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class LogDTO {

    private UUID id;

    @NotNull
    private String log;

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public LogDTO(@NotNull String log) {
        this.log = log;
    }

    public LogDTO() {
    }

    public LogDTO(UUID id, @NotNull String log) {
        this.id = id;
        this.log = log;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
