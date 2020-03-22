package br.com.codenation.centralerrosapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;



@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "users")
public class User{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String tokenAccess;
}
