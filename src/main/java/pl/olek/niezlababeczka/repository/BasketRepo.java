package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Basket;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long> {
}
