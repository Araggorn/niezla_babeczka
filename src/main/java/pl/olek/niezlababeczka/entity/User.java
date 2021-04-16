package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@ToString
@Table(name = "users")
public class User extends ParentEntity {

    @NotNull
    @Column(unique = true)
    @Size (min=3, max=50)
    private String login;

    @Email
    @NotNull
    @Column(unique = true, nullable = false)
    private String mail;

    @NotNull
    @Size(min=3, max=72, message = "Password should be longer than two letters")
    private String password;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    @Column(name = "role")
    private String role = "ROLE_USER";


    public User(String login, String mail, String password, Set<Order> orders, String role) {
        super(UUID.randomUUID());
        this.login = login;
        this.mail = mail;
        this.password = password;
        this.orders = orders;
        this.role = role;
    }

    public User() {
    }
}
