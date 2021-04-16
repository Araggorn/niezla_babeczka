package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.olek.niezlababeczka.entity.User;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class UserShowDto {

    private UUID id;
    private String login;
    private String email;

    public static UserShowDto toDto (User user) {
        return UserShowDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getMail())
                .build();

    }
}
