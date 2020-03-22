package br.com.codenation.centralerrosapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String tokenAccess;
}
