package br.com.codenation.centralerrosapi.DTO;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

public class ErrorDTO {

    private UUID id;

    @NotNull(message = "Environment required.")
    @Size(max = 50)
    private String environment;

    @Size(max = 50)
    @NotNull(message = "Description required.")
    private String description;

    @NotNull(message = "Log required.")
    @Size(max = 255)
    private String log;

    @NotNull(message = "Level required")
    private char level;

    @Size(max = 50)
    @NotNull(message = "Origin required.")
    private String origin;

    @NotNull(message = "Frequency required.")
    private int frequency;

    @CreatedDate
    @NotNull(message = "Event Date required.")
    private LocalDate eventDate;

    public ErrorDTO() {
    }

    public ErrorDTO(UUID id, @NotNull(message = "Environment required.") @Size(max = 50) String environment, @Size(max = 50) @NotNull(message = "Description required.") String description, @NotNull(message = "Log required.") @Size(max = 255) String log, @NotNull(message = "Level required") char level, @Size(max = 50) @NotNull(message = "Origin required.") String origin, @NotNull(message = "Frequency required.") int frequency, @NotNull(message = "Event Date required.") LocalDate eventDate) {
        this.id = id;
        this.environment = environment;
        this.description = description;
        this.log = log;
        this.level = level;
        this.origin = origin;
        this.frequency = frequency;
        this.eventDate = eventDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char level) {
        this.level = level;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
