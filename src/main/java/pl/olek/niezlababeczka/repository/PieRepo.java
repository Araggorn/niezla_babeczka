package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Pie;

@Repository
public interface PieRepo extends JpaRepository <Pie, Long> {
}
