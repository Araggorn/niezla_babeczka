package pl.olek.niezla_babeczka.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.olek.niezla_babeczka.dto.UserAddDto;
import pl.olek.niezla_babeczka.dto.UserShowDto;
import pl.olek.niezla_babeczka.service.UserService;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserShowDto> usersList() {
        return userService.showAllUsers();
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<UserShowDto> getUserById(@PathVariable("id") Long id){
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserAddDto> userAdd (@RequestBody UserAddDto userAddDto){
        UserAddDto savedUser = userService.addUser(userAddDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        log.info("Request to delete user id: {}", id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<UserAddDto> editUser (@RequestBody UserAddDto userDto, @PathVariable("id") Long id){
        UserAddDto user = userService.updateUser(userDto, id);
        return ResponseEntity.ok(user);
    }

    @PostConstruct
    void createSampleUser() {
        userService.addUser(UserAddDto.builder()
        .login("Olek")
        .email("drednor@o2.pl")
        .password("xx")
        .build());
    }
}