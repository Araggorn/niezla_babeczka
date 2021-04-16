package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Order;

import java.util.UUID;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    Order getByOrderNumber(Long orderNumber);

    boolean existsByOrderNumber(Long orderNum);

    boolean existsById(UUID id);
}
