package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Sweet;

import java.util.List;
import java.util.UUID;

@Repository
public interface SweetRepo extends JpaRepository<Sweet, UUID> {

    List<Sweet> getAllByDeletedIsFalse();
}
