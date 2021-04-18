package pl.olek.niezlababeczka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olek.niezlababeczka.entity.PieOffer;

import java.util.UUID;

@Repository
public interface PieOfferRepo extends JpaRepository<PieOffer, UUID> {
}
