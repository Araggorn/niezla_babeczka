package pl.olek.niezla_babeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.olek.niezla_babeczka.dto.UserAddDto;
import pl.olek.niezla_babeczka.entity.User;
import pl.olek.niezla_babeczka.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAddDto addUser(UserAddDto userAddDto){
        User user = User.builder()
                .login(userAddDto.getLogin())
                .mail(userAddDto.getEmail())
                .password(passwordEncoder.encode(userAddDto.getPassword()))
                .build();
        user.setDeleted(false);
        User userSaved = userRepo.save(user);
        log.info("added user with id{}",userSaved.getId());
        return UserAddDto.toDto(userSaved);
    }

    public List<UserAddDto>
}
