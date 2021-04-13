package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Cake;

@Repository
public interface CakeRepo extends JpaRepository<Cake, Long> {
}
