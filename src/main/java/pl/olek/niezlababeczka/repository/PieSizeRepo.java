package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.PieSize;

import java.util.List;
import java.util.UUID;

@Repository
public interface PieSizeRepo extends JpaRepository <PieSize, UUID> {

    PieSize getById(UUID id);

    List<PieSize> getAllByDeletedIsFalse();
}
