package pl.olek.niezla_babeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.olek.niezla_babeczka.dto.UserAddDto;
import pl.olek.niezla_babeczka.dto.UserShowDto;
import pl.olek.niezla_babeczka.entity.User;
import pl.olek.niezla_babeczka.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UserShowDto> showAllUsers() {
        log.info("Show list of users");
        return userRepo.findAllByDeletedIsFalse()
                .stream()
                .map(UserShowDto::toDto)
                .collect(Collectors.toList());
    }

    public Optional<UserShowDto> findById(Long id){
        log.info("We are looking for user wiht id: {}", id);

        return userRepo.findById(id).map(UserShowDto::toDto);
    }

    public void deleteById (Long id) {
        log.info("Deleting user id: {}", id);
        User user = userRepo.getOne(id);
        user.setDeleted(true);
        userRepo.save(user);
    }

    public UserAddDto updateUser(UserAddDto addDto, Long id) {
        User user = userRepo.getOne(id);
        log.info("updating user id {}", user.getId());
        user.setLogin(addDto.getLogin());
        user.setMail(addDto.getEmail());
        user.setPassword(passwordEncoder.encode(addDto.getPassword()));

        User savedUser = userRepo.save(user);
        log.info("updated note with id: {}", savedUser.getId());
        return UserAddDto.toDto(savedUser);
    }

}
