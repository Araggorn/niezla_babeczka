package pl.olek.niezla_babeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezla_babeczka.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
