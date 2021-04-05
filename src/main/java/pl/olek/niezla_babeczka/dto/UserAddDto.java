package pl.olek.niezla_babeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.olek.niezla_babeczka.entity.User;


@Data
@AllArgsConstructor
@Builder
public class UserAddDto {

private Long id;
private String login;
private String email;
private String password;
private boolean deleted;

    public static UserAddDto toDto (User user) {
        return UserAddDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getMail())
                .password(user.getPassword())
                .deleted(user.isDeleted())
                .build();

    }
}

