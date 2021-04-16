package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.PieSize;

import java.util.UUID;

@Repository
public interface PieSizeRepo extends JpaRepository <PieSize, Long> {

    PieSize getOne(UUID id);
}
