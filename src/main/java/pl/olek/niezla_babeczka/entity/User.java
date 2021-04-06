package pl.olek.niezla_babeczka.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
    @Size(min=3, max=12, message = "Password should be longer than two letters")
    private String password;

    @OneToMany (mappedBy = "user")
    List<Order> orders = new ArrayList<>();

    @Column(name = "role")
    private String role = "ROLE_USER";


}
