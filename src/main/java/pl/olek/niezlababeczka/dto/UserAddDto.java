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

    private String login;
    private String email;
    private String password;
}

