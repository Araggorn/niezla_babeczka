package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.LayerTaste;

import java.util.Set;

@Repository
public interface LayerTasteRepo extends JpaRepository <LayerTaste, Long> {

    boolean existsByTaste(String taste);

    Set<LayerTaste> getAllByDeletedIsFalse();
}
