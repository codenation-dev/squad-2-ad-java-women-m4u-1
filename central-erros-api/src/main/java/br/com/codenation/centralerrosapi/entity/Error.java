package br.com.codenation.centralerrosapi.entity;


import org.hibernate.annotations.GenericGenerator;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@EntityListeners(AuditingEntityListener.class)
@Entity(name = "error")
public class Error {



    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String environment;

    private String description;

    private String log;

    private char level;

    private String origin;

    private int frequency;

    private LocalDate eventDate;

    public Error() {
    }

    public Error(UUID id, String environment, String description, String log, char level, String origin, int frequency, LocalDate eventDate) {
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

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
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
}
