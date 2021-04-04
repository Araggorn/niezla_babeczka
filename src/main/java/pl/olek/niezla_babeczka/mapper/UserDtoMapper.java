package pl.olek.niezla_babeczka.mapper;

import pl.olek.niezla_babeczka.dto.UserDto;
import pl.olek.niezla_babeczka.entity.User;

public class UserDtoMapper {

    public static UserDto toDto (User user){
    return UserDto.builder()
            .id(user.getId())
            .login(user.getLogin())
            .email(user.getEmail())
            .password(user.getPassword)
            .deleted(user.getDeleted)
            .build;


    }
}
