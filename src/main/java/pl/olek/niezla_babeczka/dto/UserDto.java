package pl.olek.niezla_babeczka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class UserDto {

private Long id;
private String login;
private String email;
private String password;
private boolean deleted;


}

