package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.olek.niezlababeczka.entity.User;

import java.util.UUID;


@Data
@AllArgsConstructor
@Builder
public class UserAddDto {

private UUID id;
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

