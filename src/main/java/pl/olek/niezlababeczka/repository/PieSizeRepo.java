package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.PieSize;

@Repository
public interface PieSizeRepo extends JpaRepository <PieSize, Long> {
}
