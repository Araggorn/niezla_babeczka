package pl.olek.niezlababeczka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.olek.niezlababeczka.dto.UserAddDto;
import pl.olek.niezlababeczka.dto.UserDto;
import pl.olek.niezlababeczka.entity.User;
import pl.olek.niezlababeczka.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto addUser(UserAddDto userAddDto) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .login(userAddDto.getLogin())
                .mail(userAddDto.getEmail())
                .password(passwordEncoder.encode(userAddDto.getPassword()))
                .build();
        user.setDeleted(false);
        User userSaved = userRepo.save(user);
        log.info("added user with id{}", userSaved.getId());
        return UserDto.toDto(userSaved);
    }

    public List<UserDto> showAllUsers() {
        log.info("Show list of users");
        return userRepo.findAllByDeletedIsFalse()
                .stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findById(Long id) {
        log.info("We are looking for user wiht id: {}", id);

        return userRepo.findById(id).map(UserDto::toDto);
    }

    public void deleteById(Long id) {
        log.info("Deleting user id: {}", id);
        User user = userRepo.getOne(id);
        user.setDeleted(true);
        userRepo.save(user);
    }

    public UserDto updateUser(UserAddDto addDto, Long id) {
        User user = userRepo.getOne(id);
        log.info("updating user id {}", user.getId());
        user.setLogin(addDto.getLogin());
        user.setMail(addDto.getEmail());
        user.setPassword(passwordEncoder.encode(addDto.getPassword()));

        User savedUser = userRepo.save(user);
        log.info("updated note with id: {}", savedUser.getId());
        return UserDto.toDto(savedUser);
    }

}
