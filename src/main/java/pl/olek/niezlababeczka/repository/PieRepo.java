package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Pie;

import java.util.List;
import java.util.UUID;

@Repository
public interface PieRepo extends JpaRepository <Pie, UUID> {

    boolean existsById(UUID id);

    List<Pie> getAllByDeletedIsFalse();

}
