package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.SweetOrderItem;

import java.util.Set;
import java.util.UUID;

@Repository
public interface SweetOrderItemRepo extends JpaRepository <SweetOrderItem, UUID> {
    Set<SweetOrderItem> getAllByDeletedIsFalse();
}
