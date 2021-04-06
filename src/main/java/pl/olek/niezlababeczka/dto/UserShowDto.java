package pl.olek.niezlababeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.olek.niezlababeczka.entity.User;

@Data
@AllArgsConstructor
@Builder
public class UserShowDto {

    private Long id;
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
