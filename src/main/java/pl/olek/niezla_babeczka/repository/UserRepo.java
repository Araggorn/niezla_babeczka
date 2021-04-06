package pl.olek.niezla_babeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezla_babeczka.entity.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

List<User> findAllByDeletedIsFalse();

    boolean existsByLogin(String login);

    User getByLogin(String login);
}
