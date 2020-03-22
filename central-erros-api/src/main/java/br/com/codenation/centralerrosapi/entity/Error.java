package br.com.codenation.centralerrosapi.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
    
}
