package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.CakeOrderItem;

import java.util.UUID;

@Repository
public interface CakeOrderItemRepo extends JpaRepository <CakeOrderItem, UUID> {
}
