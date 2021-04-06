package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

List<User> findAllByDeletedIsFalse();

    boolean existsByLogin(String login);

    User getByLogin(String login);
}
