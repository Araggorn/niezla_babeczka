package pl.olek.niezlababeczka.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany (mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    @Column(name = "role")
    private String role = "ROLE_USER";



}
