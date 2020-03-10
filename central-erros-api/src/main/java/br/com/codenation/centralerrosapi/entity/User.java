package br.com.codenation.centralerrosapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@EntityListeners({AuditingEntityListener.class})
@Entity
@Getter
@Setter
public class User {

    @Id
    private Long id;
}
