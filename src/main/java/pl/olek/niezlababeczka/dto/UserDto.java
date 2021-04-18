package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.olek.niezlababeczka.entity.User;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

    private UUID id;
    private String login;
    private String email;

    public static UserDto toDto(User userSaved) {
        return UserDto.builder()
                .id(userSaved.getId())
                .login(userSaved.getLogin())
                .email(userSaved.getMail())
                .build();
    }
}
