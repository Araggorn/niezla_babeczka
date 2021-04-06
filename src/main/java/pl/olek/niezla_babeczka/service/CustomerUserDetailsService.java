package pl.olek.niezla_babeczka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.olek.niezla_babeczka.repository.UserRepo;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        log.info("Searching for user by username {}", login);

        if (!userRepo.existsByLogin(login)){
            throw new UsernameNotFoundException(String.format("Username %s not found", login));
        }

        final pl.olek.niezla_babeczka.entity.User userEntity = userRepo.getByLogin(login);
        UserDetails userDetails = User.withUsername(userEntity.getLogin())
                .password(userEntity.getPassword()).authorities(userEntity.getRole())
                .build();
        return null;
    }
}
