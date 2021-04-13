package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.LayerTaste;

@Repository
public interface LayerTasteRepo extends JpaRepository <LayerTaste, Long> {
}
