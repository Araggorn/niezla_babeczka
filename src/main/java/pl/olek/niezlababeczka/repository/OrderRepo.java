package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    Order getByOrOrderNumber(Long orderNumber);

    boolean existsByOrderNumber(Long orderNum);

    boolean existsById(Long id);
}
