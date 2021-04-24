package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.CakeLayer;

import java.util.Set;
import java.util.UUID;

@Repository
public interface CakeLayerRepo extends JpaRepository<CakeLayer, UUID> {
    Set<CakeLayer> getAllByDeletedIsFalse();
}
